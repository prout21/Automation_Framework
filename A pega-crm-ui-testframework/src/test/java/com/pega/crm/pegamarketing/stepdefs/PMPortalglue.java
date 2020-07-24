package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.crm.pegamarketing.PMPortal;
import com.pega.crm.pegamarketing.PMPortal.LandingPageType;
import com.pega.crm.pegamarketing.pages.CampaignsFrame;
import com.pega.crm.pegamarketing.pages.DataFlows;
import com.pega.crm.pegamarketing.pages.Eligibilities;
import com.pega.crm.pegamarketing.pages.LandingPage;
import com.pega.crm.pegamarketing.pages.Offers;
import com.pega.crm.pegamarketing.pages.ProspectLists;
import com.pega.crm.pegamarketing.pages.Segments;
import com.pega.crm.pegamarketing.pages.Strategies;
import com.pega.crm.pegamarketing.pages.Treatments;
import com.pega.crm.pegamarketing.rules.Campaign;
import com.pega.crm.pegamarketing.rules.MarketingStrategy;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class PMPortalglue {

	private PMPortal pmPortal;
	CampaignsFrame campaigns;
	Campaign campaign;
	Strategies strategies;
	MarketingStrategy strategy;
	Eligibilities eligibilities;
	DataFlows dataflows;
	ProspectLists prospectLists;
	private CRMTestEnvironment testEnv;
	private CRMBrowser browser;
	private ObjectsBean objectsBean;
	@Inject
	public PMPortalglue(CRMTestEnvironment testEnv, ObjectsBean objectsBean) {
		this.testEnv = testEnv;
		browser=(CRMBrowser) testEnv.getBrowser();
		this.objectsBean=objectsBean;
		pmPortal = browser.getPMPortal();

	}

	@When("^User expands Audiences$")
	public void user_opens_Audiences() {
		pmPortal.expandMenuItems("Audiences");
	}

	@When("^User expands Content from the Left Nav$")
	public void user_expands_Content_from_the_Left_Nav() {
		pmPortal.expandMenuItems("Content");
	}

	@When("^Opens Segments landing page$")
	public void opens_Segments_landing_page() {
		Segments segments = (Segments) pmPortal.openLandingPage(LandingPageType.SEGMENTS);
		objectsBean.setSegments(segments);
	}

	@When("^User opens Campaigns Landing Page$")
	public void user_opens_Campaigns_Landing_Page() {
		campaigns = (CampaignsFrame) pmPortal.openLandingPage(LandingPageType.CAMPAIGNS);
		objectsBean.setCampaigns(campaigns);
	}

	@When("^User opens Strategies from PMPortal$")
	public void user_opens_Strategies_from_PMPortal() {
		strategies = (Strategies) pmPortal.openLandingPage(LandingPageType.STRATEGIES);
		objectsBean.setStrategies(strategies);
	}

	@Then("^User should be on pega marketing portal$")
	public void user_should_be_on_pega_marketing_portal() {
		pmPortal = objectsBean.getPMPortal();
		Assert.assertTrue(pmPortal.verifyElement(PMPortal.PEGA_MARKETING_TITLE_TEXT),
				"User is not on Pega Marketing Portal");
	}

	@When("^User creates a strategy using guide me through it$")
	public void create_a_strategy_using_guide_me_through_it() {
		strategy = strategies.createStrategyViaGuideMeThroughIt();
		objectsBean.setStrategy(strategy);
	}

	@When("^Opens Treatment landing page$")
	public void opens_Treatment_landing_page() {
		Treatments treatments = (Treatments) pmPortal.openLandingPage(LandingPageType.TREATMENTS);
		objectsBean.setTreatments(treatments);
	}

/*	@When("^Opens Offers landing page$")
	public void opens_Offers_landing_page() {
		Offers offers = (Offers) pmPortal.openLandingPage(LandingPageType.OFFERS);
		objectsBean.setOffers(offers);
	}*/
	
	@When("^Opens Offers landing page$")
	public void openOffersLandingPage() {
		Offers offers = (Offers) pmPortal.openLandingPage(LandingPageType.ACTIONS);
		objectsBean.setOffers(offers);
	}
	

	@When("^Marketer expands Intelligence and navigates to Strategies$")
	public void marketer_expands_and_navigates_to_Strategies() {
		pmPortal.expandMenuItems("Intelligence");
		strategies = (Strategies) pmPortal.openLandingPage(LandingPageType.STRATEGIES);
		objectsBean.setStrategies(strategies);
	}

	@When("^User expands Intelligence and navigates to Strategies$")
	public void user_navigates_to_Strategies_option_through_Intelligence() {
		pmPortal.expandMenuItems("Intelligence");
		strategies = (Strategies) pmPortal.openLandingPage(LandingPageType.STRATEGIES);
		objectsBean.setStrategies(strategies);
	}

	@Then("^\"([^\"]*)\" landing Page should be opened$")
	public void landing_Page_should_be_open(String landingPageName) {
		System.out.println(
				"****** Landing Page text is " + pmPortal.findElement(LandingPage.LANDING_PAGE_HEADER).getText());
		Assert.assertTrue(pmPortal.findElement(LandingPage.LANDING_PAGE_HEADER).getText().contains(landingPageName),
				"" + landingPageName + "Landing Page is not open");
	}

}
