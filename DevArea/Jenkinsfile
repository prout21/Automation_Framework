#!groovy

def buildMode = "default"
def doBuild = false
def doTest = false
def nightlyBuild = false

// Artifactory parameter
pkg_repos = "DXC-VF"

// Cron job setting for nightly build. Branch fb-test* will be included for nightlybuild.
def schedule = env.BRANCH_NAME.contains('develop')  ? "0 11 * * 1-5" : ""

pipeline {
    agent {dockerfile true}
    
    triggers {
        cron(schedule)
    }

    environment {
        // Here define the environment variables
        MCCM_AUTOMATION_REPO_URL = "github.dxc.com/DXC-VF/mccm_automation.git"
        REPO = "mccm_automation"
    }// environment
    
    options {
        // set Build delete information for Jenkins
        buildDiscarder(logRotator(daysToKeepStr: '10', numToKeepStr: '20', artifactNumToKeepStr: '20'))
        timestamps()
        disableConcurrentBuilds()
    }//options
    
    stages {
        //Later use some code quality check tool
        stage('codequalitycheck') {
            steps {
                echo "Do Static Code Checking, Spell Checking, Syntax Checking, etc."
            }
        } // codequalitycheck
    
        stage('Build') {
            steps {
                    echo "Building...."
                    sh '''
                        cd ${WORKSPACE}
                        mvn compile
                    '''
            }
        } //stage (Build)
        stage('Test')
        {
            environment {
                // These are user defined environment variables.
                REMOTE_MACHINE = "10.0.4.99"
                REST_API_ENDPOINT_HOST = "10.0.4.159"
                BASTION_MACHINE = "3.120.110.152"
                REMOTE_USER = "dxc_dev"
            }
            steps {
                    script {
                        echo "Testing...."
                        sshagent (credentials: ['DEV_MACHINE_SSH_KEY']) {
                            sh '''
                                # setting ssh timeout.
                                if [ ! -f ~/.ssh/config ];then
                                    mkdir ~/.ssh
                                    touch ~/.ssh/config
                                fi
                                echo "Host *" >>~/.ssh/config
                                echo "  ServerAliveInterval 300" >>~/.ssh/config
                                echo "  ServerAliveCountMax 5" >>~/.ssh/config
                                cat ~/.ssh/config
                                
                                ssh -N -o StrictHostKeyChecking=no -L 9022:${REMOTE_MACHINE}:22 dxc_dev@${BASTION_MACHINE} -p 18881 &
                                ssh -N -o StrictHostKeyChecking=no -L 18576:${REST_API_ENDPOINT_HOST}:8002 dxc_dev@${BASTION_MACHINE} -p 18881 &
                                cd ${WORKSPACE}
                                # Update properties file with actual WORKSPACE.
                                sed -i -e 's|${WORKSPACE}|'${WORKSPACE}'|g' UseCaseConfigFile/configurationFile.properties
                                # Port fordwaring to rest endpoint.
                                sed -i -e 's|192.57.138.25|localhost|g' UseCaseConfigFile/configurationFile.properties
                                sed -i -e 's|${WORKSPACE}|'${WORKSPACE}'|g' UseCaseConfigFile/Config.properties
                                sed -i -e 's|${WORKSPACE}|'${WORKSPACE}'|g' UseCaseConfigFile/UseCaseConfigFile.properties
                                # Run inside a script 
                                echo 'xvfb-run --server-args="-screen 0 1024x768x24" mvn test ' >runTest.sh
                                echo "exit 0" >>runTest.sh
                                chmod +x runTest.sh
                                cat runTest.sh
                                ./runTest.sh
                                #xvfb-run --server-args="-screen 0 1024x768x24" mvn test
                            '''
                        }
                        stash name: "TestReport" , includes: "**/TestReport/Test-Automaton-Report.html"
                    }
                    
            }
        } // (End of Test)
        
        stage('Store to Jenkins') {
            // Here we store the results of test.
            steps {
                    echo "Saving Test results."
                    unstash "TestReport"
                    archiveArtifacts artifacts: '**/TestReport/Test-Automaton-Report.html', fingerprint: true
            } 
        }// (End of Store to Jenkins)	
        stage('Send message MS TEAMS'){
            when { 
                allOf {
                    triggeredBy cause: "TimerTrigger"
                    expression { BRANCH_NAME ==~ /(develop)/ }
                }  
            }
            steps {
                sh "echo send message"
                //sending messages to MS Teams does not require a special stage
                //From MS Teams add the enterprise github connector to your channel and follow the direction to add the webhook to github
                //After this is setup and configured you MS Team channel will receive message from github and jenkins.                  
                script {
                    nightlyBuild = true
                    def passed  = sh(returnStdout: true, script: ''' grep "test(s) passed" TestReport/Test-Automaton-Report.html |awk -F">" '{print $3}'|awk -F"<" '{print $1}' ''')
                    def failed  = sh(returnStdout: true, script: ''' grep "test(s) failed" TestReport/Test-Automaton-Report.html |awk -F">" '{print $2}'|awk -F"<" '{print $1}' ''')
                    def others  = sh(returnStdout: true, script: ''' grep "test(s) failed" TestReport/Test-Automaton-Report.html |awk -F">" '{print $4}'|awk -F"<" '{print $1}' ''')

                    def msg = "<pre><h2>MCCM-Automation Test Results</h2><b>Passed     " + passed + "</b><b>Failed     " + failed + "</b><b>Others     " + others + "</b></pre>"
                    office365ConnectorSend message: msg , status: "Nightly build Success", webhookUrl: 'https://outlook.office.com/webhook/a1e5ba23-63a3-4537-977e-e2191201fb75@93f33571-550f-43cf-b09f-cd331338d086/JenkinsCI/44ea78e1198249ddb18bc0c0f2b80c62/19011347-d504-4b65-9a0a-0b676f0b9762'
                }     
            }
            //steps
        } 
        // Send message MS TEAMS
    } // Stages
    
    post {
        always {
            echo 'One way or another, I have finished'
            deleteDir() /* clean up our workspace */
        }

        success {
            echo 'I succeeded!!!!!!!!!!!!!!'   
        }

        unstable {
            echo 'I am unstable :/'
        }

        failure {
            echo 'I failed :(' 
            script {
                if(env.BRANCH_NAME == "develop" && nightlyBuild) {
                    office365ConnectorSend message: "Build: Failed" , status: "Nightly build Failed", webhookUrl: 'https://outlook.office.com/webhook/a1e5ba23-63a3-4537-977e-e2191201fb75@93f33571-550f-43cf-b09f-cd331338d086/JenkinsCI/44ea78e1198249ddb18bc0c0f2b80c62/19011347-d504-4b65-9a0a-0b676f0b9762'
                }
                // emailext body: '"Log Url: (<${env.BUILD_URL}|Open>)"', subject: 'Build Failed', to: 'someemail@dxc.com'
            }       
        }

        changed {
            echo 'Things were different before...'
        }
    } // Post
        
}// pipeline
