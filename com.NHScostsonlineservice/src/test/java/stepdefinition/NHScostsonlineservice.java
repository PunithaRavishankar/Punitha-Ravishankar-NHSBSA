package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageObject.NHSCostCheckerTool;
import utilityPack.BaseClass;
import utilityPack.Browsersetup;

import utilityPack.GlobalVariables;

public class NHScostsonlineservice {
	Browsersetup bSetup = null;
	GlobalVariables gbVar = new GlobalVariables();
	BaseClass base = new BaseClass();
	NHSCostCheckerTool start = new NHSCostCheckerTool();
	NHSCostCheckerTool cp = new NHSCostCheckerTool();

	@Before
	public void setupBrowser() {
		bSetup = new Browsersetup();
		gbVar.driver = bSetup.browserConfig(gbVar.chromeBrowserName);
		gbVar.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void closeBrowser(Scenario scenario)
	{
	TakesScreenshot ts = (TakesScreenshot) gbVar.driver;
	byte[] src = ts.getScreenshotAs(OutputType.BYTES);
	if (scenario.isFailed()) {
		scenario.attach(src, "image/png", "Failure_Screenshot");
	} else {
		scenario.attach(src, "image/png", "Completed_Screenshot");
	}
	base.close(gbVar.driver);
}

	@Given("user navigates to the application")
	public void user_navigates_to_the_application() {
		base.navigateToUrl(gbVar.driver, gbVar.url);
	}
	@When("user accepts or declines the cookies if flag is selected as [accept_cookies: {string}]")
	public void user_accepts_or_declines_the_cookies_if_flag_is_selected_as_accept_cookies(String flagValue) {
		try {
			if (flagValue.toUpperCase().equals("Y")) {
				base.scrollToElement(gbVar.driver, cp.acceptOrRejectCookies(gbVar.driver, "OK with analytics cookies"));
				base.clickElement(cp.acceptOrRejectCookies(gbVar.driver, "OK with analytics cookies"));
			} else {
				base.scrollToElement(gbVar.driver,
						cp.acceptOrRejectCookies(gbVar.driver, "Do not use analytics cookies"));
				base.clickElement(cp.acceptOrRejectCookies(gbVar.driver, "Do not use analytics cookies"));
			}
		} catch (Exception e) {
		}
	}

	@Given("navigating to NHS Costs Checker tool")
	public void navigating_to_nhs_costs_checker_tool() {
		base.navigateToUrl(gbVar.driver, gbVar.url);
	}

	@When("clicking on Start Now to access the Link")
	public void clicking_on_start_now_to_access_the_link() {
		base.clickElement(start.StartNow(gbVar.driver));
	}

	@When("I am a citizen of the UK by selecting country as Scotland")
	public void i_am_a_citizen_of_the_uk_by_selecting_country_as_scotland() {
		base.clickElement(start.Country(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select do you live in the Highlands and Islands? as Yes")
	public void select_do_you_live_in_the_highlands_and_islands_as_yes() {
		base.clickElement(start.YesButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select country dental practice in? as I am not registered with a dental practice")
	public void select_country_dental_practice_in_as_i_am_not_registered_with_a_dental_practice() {
		base.clickElement(start.dental(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Enter date of birth in Day DD : {string}")
	public void enter_date_of_birth_in_day_dd(String Date) {
		base.type(start.Day(gbVar.driver), Date);
		base.hardWait(1000);
	}

	@When("Enter date of birth in  Month MM :{string}")
	public void enter_date_of_birth_in_month_mm(String Month) {
		base.type(start.Month(gbVar.driver), Month);
		base.hardWait(1000);
	}

	@When("Enter date of birth in  Year YYYY :{string}")
	public void enter_date_of_birth_in_year_yyyy(String Year) {
		base.type(start.Year(gbVar.driver), Year);
		base.hardWait(1000);
		base.clickElement(start.Next(gbVar.driver));

	}

	@When("Select live with a partner as No")
	public void select_live_with_a_partner_as_no() {
		base.clickElement(start.NoButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select you or your partner claim any benefits or tax credits? as No")
	public void select_you_or_your_partner_claim_any_benefits_or_tax_credits_as_no() {
		base.clickElement(start.NoButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select are you pregnant or have you given birth in the last {int} months as No")
	public void select_are_you_pregnant_or_have_you_given_birth_in_the_last_months_as_no(Integer int1) {
		base.clickElement(start.NoButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select do you have an injury or illness caused by serving in the armed forces? as No")
	public void select_do_you_have_an_injury_or_illness_caused_by_serving_in_the_armed_forces_as_no() {
		base.clickElement(start.NoButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select do you live permanently in a care home? as No")
	public void select_do_you_live_permanently_in_a_care_home_as_no() {
		base.clickElement(start.NoButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select do you and your partner have more than £{double} in savings, investments or property? No")
	public void select_do_you_and_your_partner_have_more_than_£_in_savings_investments_or_property_no(Double double1) {
		base.clickElement(start.NoButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}
	
	@When("I am a citizen of the UK by selecting country as England")
	public void i_am_a_citizen_of_the_uk_by_selecting_country_as_england() {
		base.clickElement(start.Country1(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));    
	}

	@When("Select GP practice in Scotland or Wales? Yes")
	public void select_gp_practice_in_scotland_or_wales_yes() {
		base.clickElement(start.YesButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select country dental practice in? England")
	public void select_country_dental_practice_in_england() {
		base.clickElement(start.dental2(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select live with a partner as Yes")
	public void select_live_with_a_partner_as_yes() {
		base.clickElement(start.YesButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select you or your partner claim any benefits or tax credits? as Yes")
	public void select_you_or_your_partner_claim_any_benefits_or_tax_credits_as_yes() {
		base.clickElement(start.YesButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select you or your partner get paid Universal Credit? as Yes, we receive Universal Credit payments")
	public void select_you_or_your_partner_get_paid_universal_credit_as_yes_we_receive_universal_credit_payments() {
		base.clickElement(start.UniversalCredit(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select As part of your joint Universal Credit, do you have any of these? As Yes")
	public void select_as_part_of_your_joint_universal_credit_do_you_have_any_of_these_as_yes() {
		base.clickElement(start.YesButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select Did you and your partner have a combined take-home pay of £{int} or less in your last Universal Credit period? As Yes")
	public void select_did_you_and_your_partner_have_a_combined_take_home_pay_of_£_or_less_in_your_last_universal_credit_period_as_yes(Integer int1) {
		base.clickElement(start.YesButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}
	@Then("I am a citizen of the UK by selecting country as Northern Ireland")
	public void i_am_a_citizen_of_the_uk_by_selecting_country_as_northern_ireland() {
		base.clickElement(start.Country2(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));    
	}
	@When("I am a citizen of the UK by selecting country as Wales")
	public void i_am_a_citizen_of_the_uk_by_selecting_country_as_wales() {
		base.clickElement(start.Country3(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));  
	}

	@When("Is your GP practice in Scotland or Wales? As No")
	public void is_your_gp_practice_in_scotland_or_wales_as_no() {
		base.clickElement(start.NoButton(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@When("Select country dental practice in? as Wales")
	public void select_country_dental_practice_in_as_wales() {
		base.clickElement(start.dental3(gbVar.driver));
		base.hardWait(2000);
		base.clickElement(start.Next(gbVar.driver));
	}

	@Then("Click on Back Button to change you and your partner have more than £{double} in savings, investments or property? Yes from No")
	public void clcik_on_back_button_to_change_you_and_your_partner_have_more_than_£_in_savings_investments_or_property_yes_from_no(
			Double double1) {
		base.clickElement(start.BackButton(gbVar.driver));
		base.clickElement(start.YesButton(gbVar.driver));
		base.hardWait(2000);
	}

	@Then("Going back to Select country dental practice in? Change Scotland to as I am not registered with a dental practice")
	public void going_back_to_select_country_dental_practice_in_change_scotland_to_as_i_am_not_registered_with_a_dental_practice() {
		for(int i=1;i<=7;i++)
		{
			base.clickElement(start.BackButton(gbVar.driver));
		}
		base.clickElement(start.dental1(gbVar.driver));
		base.hardWait(2000);
		for(int i=1;i<=7;i++)
		{
			base.clickElement(start.Next(gbVar.driver));
		}
	}
	@Then("Click on the Why we ask for your date of birth link")
	public void click_on_the_why_we_ask_for_your_date_of_birth_link() {
		base.clickElement(start.LinkDOB(gbVar.driver));
		base.hardWait(2000);
	}
	@Then("Select do you live in the Highlands and Islands? as Blank")
	public void select_do_you_live_in_the_highlands_and_islands_as_blank() {
		base.clickElement(start.Next(gbVar.driver));
	}

}
