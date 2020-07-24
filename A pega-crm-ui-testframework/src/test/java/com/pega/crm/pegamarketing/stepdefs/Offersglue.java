package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.crm.pegamarketing.pages.Offers;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
@ScenarioScoped
public class Offersglue {
	
	private ObjectsBean objectsBean;
	private CRMTestEnvironment testEnv;
	
	@Inject
	public Offersglue(CRMTestEnvironment testEnv, ObjectsBean objectsBean) {
		this.testEnv = testEnv;
		this.objectsBean=objectsBean;
	}
	@Then("^Offers landing Page should be displayed$")
	public void treatment_Landing_Page_should_be_displayed() {
		Offers offers = objectsBean.getOffers();
		Assert.assertTrue(offers.verifyElement(Offers.OFFERS_PAGE_HEADER), "Offers landing page is not opened..!!");
	}

	@When("^User creates offer$")
	public void user_creates_offer() {
		Offers offers = objectsBean.getOffers();
		Offer offer = offers.create();
		objectsBean.setOffer(offer);
	}

}
