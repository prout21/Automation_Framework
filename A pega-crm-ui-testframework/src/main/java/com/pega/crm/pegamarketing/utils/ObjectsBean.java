package com.pega.crm.pegamarketing.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.pega.config.ObjectBean;
import com.pega.config.PegaObjectBean;
import com.pega.crm.pegamarketing.DesignerStudio;
import com.pega.crm.pegamarketing.ExpressPortal;
import com.pega.crm.pegamarketing.PMPortal;
import com.pega.crm.pegamarketing.dialog.ImageCatalogDialog;
import com.pega.crm.pegamarketing.pages.CampaignsFrame;
import com.pega.crm.pegamarketing.pages.Channels;
import com.pega.crm.pegamarketing.pages.Channels.PaidMediaSetting;
import com.pega.crm.pegamarketing.pages.ContextDictionary;
import com.pega.crm.pegamarketing.pages.DataFlows;
import com.pega.crm.pegamarketing.pages.Eligibilities;
import com.pega.crm.pegamarketing.pages.ImageLibrary;
import com.pega.crm.pegamarketing.pages.Microsites;
import com.pega.crm.pegamarketing.pages.Offers;
import com.pega.crm.pegamarketing.pages.PaidMediaAudiences;
import com.pega.crm.pegamarketing.pages.ProspectLists;
import com.pega.crm.pegamarketing.pages.RealTimeArtifacts;
import com.pega.crm.pegamarketing.pages.RecentReports;
import com.pega.crm.pegamarketing.pages.Segments;
import com.pega.crm.pegamarketing.pages.Segments.ImageCatalog;
import com.pega.crm.pegamarketing.pages.ServiceRestRecords;
import com.pega.crm.pegamarketing.pages.Strategies;
import com.pega.crm.pegamarketing.pages.Subscription;
import com.pega.crm.pegamarketing.pages.Summaries;
import com.pega.crm.pegamarketing.pages.Treatments;
import com.pega.crm.pegamarketing.pages.UnsubscribedCustomers;
import com.pega.crm.pegamarketing.pages.UnsubscribedCustomers.SubscriptionReportDrillDown;
import com.pega.crm.pegamarketing.rules.Campaign;
import com.pega.crm.pegamarketing.rules.Campaign.CampaignConfigureDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureAudienceDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureDetailsDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureEngagementCriteriaDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureEngagementDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureMarketingStrategyDialog;
import com.pega.crm.pegamarketing.rules.Campaign.ConfigureTimeframeDialog;
import com.pega.crm.pegamarketing.rules.Designer;
import com.pega.crm.pegamarketing.rules.EmailTreatment;
import com.pega.crm.pegamarketing.rules.MarketingStrategy;
import com.pega.crm.pegamarketing.rules.MarketingStrategy.ConfigureObjectiveDialog;
import com.pega.crm.pegamarketing.rules.MarketingStrategy.ConfigurePriorityDialog;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.rules.PropositionFilter;
import com.pega.crm.pegamarketing.rules.ProspectImport;
import com.pega.crm.pegamarketing.rules.SMSTreatment;
import com.pega.crm.pegamarketing.rules.Segment;
import com.pega.crm.pegamarketing.rules.WhenRule;
import com.pega.crm.pegamarketing.rules.WhenRule.ConditionDialog;

import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class ObjectsBean extends PegaObjectBean implements ObjectBean{

	private Segments segments;
	 Eligibilities eligibilities;
	 String Strategy1, Strategy2, Campaign1, Campaign2;
	private ConfigurePriorityDialog configurePriorityDialog;
	private ImageCatalog ic;
	private static HashMap<String, String> timeStamps = new HashMap<>();
	private Segment segment;
	private Map<String, String> objectNames = new LinkedHashMap<String, String>();
	private DesignerStudio designerStudio;
	private PMPortal pmPortal;
	private Designer designer;
	private CampaignsFrame campaigns;
	private ContextDictionary contextDictionaryFrame;
	private ExpressPortal expressPortal;
	private com.pega.crm.pegamarketing.rules.Designer.ConfigureBussinessIssuesDialog configBussIssue;
	private Campaign campaign;
	private ConfigureMarketingStrategyDialog configureMarketingStrategyDialog;
	private RealTimeArtifacts realTimeArtifacts;
	private Treatments treatments;
	private ConfigureAudienceDialog configureAudienceDialog;
	private ConfigureEngagementDialog configureEngagementDialog;
	private Strategies strategy;
	private MarketingStrategy marketingStrat;
	private ConfigureObjectiveDialog confgObjectiveDialog;
	private EmailTreatment emailTreatment;
	private Offers offers;
	private Offer offer;
	private WhenRule when;
	private ConditionDialog conditionDialog;
	private PropositionFilter propositionfilter;
	private SMSTreatment smsTreatment;
	private ProspectLists prospectLists;
	private ProspectImport prospectImport;
	private Channels channels;
	private Microsites microsites;
	private DataFlows dataFlows;
	private Summaries summaries;
	private RecentReports recentreports;
	private UnsubscribedCustomers unsubscribedCustomers;
	private ServiceRestRecords serviceRestRecords;
	private Subscription subsription;
	private SubscriptionReportDrillDown subscriptionDrillDrown;
	private PaidMediaSetting pegapaidmedia;
	private PaidMediaAudiences paidMediaAudiences;
	private ImageLibrary imageLibrary;
	private ImageCatalogDialog imgCatalog;

	public ConfigureEngagementCriteriaDialog configureEngagementCriteriaDialog;
	public CampaignConfigureDialog cardSelectorDialog;
	public ConfigureTimeframeDialog configureTimeframeDialog;
	public ConfigureDetailsDialog configureDetailsDialog;

	public void setSegments(Segments segments) {
		this.segments = segments;
	}

	public Segments getSegments() {
		return this.segments;
	}

	public void setStrategyName(String Strategy1) {
		this.Strategy1 = Strategy1;
	}

	public String getStrategyName() {
		return this.Strategy1;
	}

	public void setStrategyName1(String Strategy2) {
		this.Strategy2 = Strategy2;
	}

	public String getStrategyName1() {
		return this.Strategy2;
	}

	public void setImageCatalog(ImageCatalog ic) {
		this.ic = ic;
	}

	public ImageCatalog getImageCatalog() {
		return this.ic;
	}

	public String putTimeStampedValue(String name) {
		String existingValue = timeStamps.get(name);
		if (existingValue == null) {
			String value = appendTimeStamp(name);
			this.timeStamps.put(name, value);
			return value;
		} else {
			return existingValue;
		}
	}

	public static String getTimeStampedValue(String name) {
		String value = timeStamps.get(name);
		if (value != null) {
			return value;
		} else {
			return name;
		}
	}

	private String appendTimeStamp(String string) {
		String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
		return string + timeStamp;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}

	public Segment getSegment() {
		return this.segment;
	}

	public void setDesignerStudio(DesignerStudio designerStudio) {
		this.designerStudio = designerStudio;
	}

	public DesignerStudio getDesignerStudio() {
		return designerStudio;
	}

	public void setPMPortal(PMPortal pmPortal) {
		this.pmPortal = pmPortal;
	}

	public PMPortal getPMPortal() {
		return pmPortal;
	}

	public void setDesigner(Designer designer) {
		this.designer = designer;
	}

	public Designer getDesigner() {
		return designer;
	}

	public void setContextDictionaryFrame(ContextDictionary contextDictionaryFrame) {
		this.contextDictionaryFrame = contextDictionaryFrame;
	}

	public ContextDictionary getContextDictionaryFrame() {
		return this.contextDictionaryFrame;
	}

	public ExpressPortal getExpressPortal() {
		return this.expressPortal;
	}

	public void setExpressPortal(ExpressPortal expressPortal) {
		this.expressPortal = expressPortal;
	}

	public void setConfigBussinessIssueDialog(
			com.pega.crm.pegamarketing.rules.Designer.ConfigureBussinessIssuesDialog configBussIssue) {
		this.configBussIssue = configBussIssue;
	}

	public com.pega.crm.pegamarketing.rules.Designer.ConfigureBussinessIssuesDialog getConfigBussinessIssuesDialog() {
		return this.configBussIssue;
	}

	public Map<String, String> getObjectNames() {
		return objectNames;
	}

	public void setCampaigns(CampaignsFrame campaigns) {
		this.campaigns = campaigns;
	}

	public CampaignsFrame getCampaigns() {
		return campaigns;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setConfigureMarketingStrategyDiaolg(
			ConfigureMarketingStrategyDialog configureMarketingStrategyDialog) {
		this.configureMarketingStrategyDialog = configureMarketingStrategyDialog;
	}

	public ConfigureMarketingStrategyDialog getConfigureMarketingStrategyDialog() {
		return configureMarketingStrategyDialog;
	}

	public void setRealTimeArtifacts(RealTimeArtifacts realTimeArtifacts) {
		this.realTimeArtifacts = realTimeArtifacts;

	}

	public RealTimeArtifacts getRealTimeArtifacts() {
		return this.realTimeArtifacts;

	}

	public void setTreatments(Treatments treatments) {
		this.treatments = treatments;
	}

	public void setOffers(Offers offers) {
		this.offers = offers;
	}

	public Treatments getTreatments() {
		return this.treatments;
	}

	public Offers getOffers() {
		return this.offers;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setConfigureAudienceDiaolg(ConfigureAudienceDialog configureAudienceDialog) {
		this.configureAudienceDialog = configureAudienceDialog;
	}

	public ConfigureAudienceDialog getConfigureAudienceDialog() {
		return configureAudienceDialog;
	}

	public void setConfigureEngagementDiaolg(ConfigureEngagementDialog configureEngagementDialog) {
		this.configureEngagementDialog = configureEngagementDialog;
	}

	public ConfigureEngagementDialog getConfigureEngagementDialog() {
		return configureEngagementDialog;
	}

	public void setConfigureEngagementCriteriaDialog(
			ConfigureEngagementCriteriaDialog configureEngagementCriteriaDialog) {
		this.configureEngagementCriteriaDialog = configureEngagementCriteriaDialog;
	}

	public ConfigureEngagementCriteriaDialog getConfigureEngagementCriteriaDialog() {
		return configureEngagementCriteriaDialog;
	}

	public void setCardSelectorDialog(CampaignConfigureDialog cardSelectorDialog) {
		this.cardSelectorDialog = cardSelectorDialog;
	}

	public CampaignConfigureDialog getCardSelectorDialog() {
		return cardSelectorDialog;
	}

	public void setConfigureTimeframeDialog(ConfigureTimeframeDialog configureTimeframeDialog) {
		this.configureTimeframeDialog = configureTimeframeDialog;
	}

	public ConfigureTimeframeDialog getConfigureTimeframeDialog() {
		return configureTimeframeDialog;
	}

	public void setConfigureDetailsDialog(ConfigureDetailsDialog configureDetailsDialog) {
		this.configureDetailsDialog = configureDetailsDialog;
	}

	public ConfigureDetailsDialog getConfigureDetailsDialog() {
		return configureDetailsDialog;
	}

	public void setStrategies(Strategies strategies) {
		this.strategy = strategies;
	}

	public Strategies getStrategies() {
		return strategy;
	}

	public void setStrategy(MarketingStrategy strategy) {
		this.marketingStrat = strategy;
	}

	public MarketingStrategy getStrategy() {
		return marketingStrat;
	}

	public void setConfigureObjectiveDialog(ConfigureObjectiveDialog confgObjectiveDialog) {
		this.confgObjectiveDialog = confgObjectiveDialog;
	}

	public ConfigureObjectiveDialog getConfigureObjectiveDialog() {
		return confgObjectiveDialog;
	}

	public void setEmailTreatment(EmailTreatment emailTreatment) {
		this.emailTreatment = emailTreatment;
	}

	public EmailTreatment getEmailTreatment() {
		return this.emailTreatment;
	}

	public void setConfigurePriorityDialog(ConfigurePriorityDialog configurePriorityDialog) {
		this.configurePriorityDialog = configurePriorityDialog;
	}

	public ConfigurePriorityDialog getConfigurePriorityDialog() {
		return configurePriorityDialog;
	}

	public void setEligibilities(Eligibilities eligibilities) {
		this.eligibilities = eligibilities;
	}

	public Eligibilities getEligibilities() {
		return eligibilities;
	}

	public void setWhen(WhenRule when) {
		this.when = when;
	}

	public WhenRule getWhen() {
		return when;
	}

	public void setConditionDialog(ConditionDialog conditionDialog) {
		this.conditionDialog = conditionDialog;
	}

	public ConditionDialog getConditionDialog() {
		return conditionDialog;
	}

	public void setPropositionFilter(PropositionFilter propositionFilter) {
		this.propositionfilter = propositionFilter;
	}

	public PropositionFilter getPropositionFilter() {
		return propositionfilter;
	}

	public SMSTreatment getSMSTreatment() {
		return smsTreatment;
	}

	public void setSMSTreatment(SMSTreatment smsTreatment) {
		this.smsTreatment = smsTreatment;
	}

	public void setProspectLists(ProspectLists prospectLists) {
		this.prospectLists = prospectLists;
	}

	public ProspectLists getProspectLists() {
		return prospectLists;
	}

	public void setProspectImport(ProspectImport prospectImport) {
		this.prospectImport = prospectImport;
	}

	public ProspectImport getProspectImport() {
		return prospectImport;
	}

	public void setChannels(Channels channels) {
		this.channels = channels;
	}

	public Channels getChannels() {
		return channels;
	}

	public void setMicrosites(Microsites microsites) {
		this.microsites = microsites;
	}

	public Microsites getMicroSites() {
		return microsites;
	}

	public void setDataFlows(DataFlows dataFlows) {
		this.dataFlows = dataFlows;
	}

	public DataFlows getDataFlows() {
		return dataFlows;
	}

	public void setSummaries(Summaries summaries) {
		this.summaries = summaries;
	}

	public Summaries getSummaries() {
		return summaries;
	}

	public void setRecentReports(RecentReports recentReports) {
		this.recentreports = recentReports;
	}

	public RecentReports getRecentReports() {
		return recentreports;
	}

	public void setUnsubscribedCustomers(UnsubscribedCustomers unsubscribedCustomers) {
		this.unsubscribedCustomers = unsubscribedCustomers;
	}

	public UnsubscribedCustomers getUnsubscribedCustomers() {
		return unsubscribedCustomers;
	}

	public ServiceRestRecords getServiceRestRecords() {
		return serviceRestRecords;
	}

	public void setServiceRestRecords(ServiceRestRecords serviceRestRecords) {
		this.serviceRestRecords = serviceRestRecords;

	}

	public Subscription getSubscription() {
		return subsription;
	}

	public void setSubscription(Subscription subscription) {
		this.subsription = subscription;
	}

	public SubscriptionReportDrillDown getSubscriptionReportDrillDown() {
		return subscriptionDrillDrown;
	}

	public void setSubscription(SubscriptionReportDrillDown subscriptionDrillDrown) {
		this.subscriptionDrillDrown = subscriptionDrillDrown;
	}

	public void setpaidmedia(PaidMediaSetting pegapaidmedia) {
		// TODO Auto-generated method stub
		this.pegapaidmedia = pegapaidmedia;
	}

	public PaidMediaSetting getpaidmedia() {
		// TODO Auto-generated method stub
		return pegapaidmedia;
	}

	public void setPaidMediaAudiences(PaidMediaAudiences paidMediaAudiences) {
		this.paidMediaAudiences = paidMediaAudiences;
	}

	public PaidMediaAudiences getPaidMediaAudiences() {
		return this.paidMediaAudiences;
	}

	public void setImageLibrary(ImageLibrary imageLibrary) {
		this.imageLibrary = imageLibrary;
	}

	public ImageLibrary getImageLibrary() {
		return this.imageLibrary;
	}

	public void setImageCatalogDialog(ImageCatalogDialog imgCatalog) {
		this.imgCatalog = imgCatalog;
	}

	public ImageCatalogDialog getImageCatalogDialog() {
		return this.imgCatalog;
	}

	public void setCampaignName(String Campaign1) {
		this.Campaign1 = Campaign1;

	}

	public void setCampaignName1(String Campaign2) {
		this.Campaign2 = Campaign2;

	}

	public String getCampaignName() {

		return Campaign1;
	}

	public String getCampaignName1() {

		return Campaign2;
	}
}
