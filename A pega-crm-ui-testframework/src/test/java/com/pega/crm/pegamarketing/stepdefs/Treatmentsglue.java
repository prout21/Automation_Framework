package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.crm.pegamarketing.PMPortal;
import com.pega.crm.pegamarketing.pages.Treatments;
import com.pega.crm.pegamarketing.rules.EmailTreatment;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
@ScenarioScoped
public class Treatmentsglue {
	private ObjectsBean objectsBean;
	private CRMTestEnvironment testEnv;
	private CRMBrowser browser;
	private PMPortal pmPortal;
	
	@Inject
	public Treatmentsglue(CRMTestEnvironment testEnv, ObjectsBean objectsBean) {
		this.testEnv = testEnv;
		browser=(CRMBrowser) testEnv.getBrowser();
		this.objectsBean=objectsBean;
		pmPortal = browser.getPMPortal();
	}

	@Then("^Treatment landing Page should be displayed$")
	public void treatment_Landing_Page_should_be_displayed() {
		Treatments treatments = objectsBean.getTreatments();
		Assert.assertTrue(treatments.verifyElement(Treatments.TREATMENTS_PAGE_HEADER),
				"Treatments landing page is not opened..!!");
	}

	@When("^User creates Email treatment$")
	public void user_creates_treatment() {
		Treatments treatments = objectsBean.getTreatments();
		treatments.create();
		EmailTreatment emailTreatment = treatments.createEmailTreatment();
		objectsBean.setEmailTreatment(emailTreatment);
	}

}
