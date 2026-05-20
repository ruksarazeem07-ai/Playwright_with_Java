package com.stepDefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import utils.ConfigConstants;
import com.dataManager.JsonDataManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.actionPages.*;
import utils.PlaywrightDriver;

public class HomePageStepDefs {

	HomePage home = new HomePage(PlaywrightDriver.getPage());

	@Given("User login as {string}")
	public void user_login_as(String loginType) {

		if (loginType.equals("admin")) {
			PlaywrightDriver.openPage(PlaywrightDriver.config.getProperty("testsiteurl"));
		}
	}

	@Given("User signIn to application")
	public void user_sign_in_to_application() {

		PlaywrightDriver.openPage(PlaywrightDriver.config.getProperty("testsiteurl"));
	}

//	@When("User enter username and password")
//	public void user_enter_username_and_password() {
//
//		home.enterUsername();
//		home.enterPassword();
//
//	}

	@When("User enter username and password in {string} as {int}")
	public void user_enter_username_and_password_in_as(String login, Integer i) throws IOException, ParseException {

		if (login.contains(ConfigConstants.admin)) {
			home.enterUsername(JsonDataManager.readData("userCredentials", i).get("username"));
			home.enterPassword(JsonDataManager.readData("userCredentials", i).get("password"));
		}
	}

	@Then("Click on login")
	public void click_on_login() throws InterruptedException {
//
		home.clickOnLogin();
//		Thread.sleep(3000);
//		System.out.println(ConfigConstants.DashboardUrl);
//		home.verifyURLContains(ConfigConstants.DashboardUrl);
	}

	@Given("User opens browser and navigate to url")
	public void user_opens_browser_and_navigate_to_url() {
		PlaywrightDriver.openPage(PlaywrightDriver.config.getProperty("testsiteurl"));
	}

	@Then("Verify that home page is visible successfully")
	public void verify_that_home_page_is_visible_successfully() {
		home.verifyURLContains(ConfigConstants.HomepageUrl);
	}

	@When("Click on {string} button")
	public void click_on_button(String buttonName) {
		if (buttonName.contains(ConfigConstants.SignupLogin)) {
			home.clickOnLoginLink();
		} else if (buttonName.contains(ConfigConstants.Signupbutton)) {
			home.clickSignUpButton();
		} else if (buttonName.contains(ConfigConstants.text3)) {
			home.clickOnCreateAccountButton();
		} else if (buttonName.contains(ConfigConstants.text4)) {
			home.clickContinueButton();
		} else if (buttonName.contains(ConfigConstants.text5)) {
			home.clickDeleteAccountButton();
		} else if (buttonName.contains(ConfigConstants.text10)) {
			home.clickOnLogin();
		}

	}

	@Then("Enter name and email address as {int}")
	public void enter_name_and_email_address_as(Integer i) throws IOException, ParseException {
		home.enterUsername(JsonDataManager.readData("userCredentials", i).get("username"));
		home.enterSiginUpEmail(JsonDataManager.readData("userCredentials", i).get("emailAddress"));
	}

	@Then("Verify that {string} is visible")
	public void verify_that_is_visible(String text) {
		home.verifyText(text);
	}

	@When("Fill Registration details as {int}")
	public void fill_Registration_details_as(Integer i) throws IOException, ParseException, InterruptedException {

		home.selectTitle();
		home.enterPassword(JsonDataManager.readData("RegistrationDetails", i).get("Password"));
		home.selectDateOfBirth();
		Thread.sleep(2000);
	}

	@When("Select checkbox {string}")
	public void select_checkbox(String Text) {
		home.CheckBox(Text);
	}

	@When("Fill Address details as {int}")
	public void fill_address_details_as(Integer i) throws IOException, ParseException {

		home.enterFirstName(JsonDataManager.readData("AddressDetails", i).get("FirstName"));
		home.enterLastName(JsonDataManager.readData("AddressDetails", i).get("LastName"));
		home.enterCompany(JsonDataManager.readData("AddressDetails", i).get("Company"));
		home.enterAddress1(JsonDataManager.readData("AddressDetails", i).get("Address1"));
		home.enterAddress2(JsonDataManager.readData("AddressDetails", i).get("Address2"));
		home.selectCountry();
		home.enterState(JsonDataManager.readData("AddressDetails", i).get("State"));
		home.enterCity(JsonDataManager.readData("AddressDetails", i).get("City"));
		home.enterZipcode(JsonDataManager.readData("AddressDetails", i).get("Zipcode"));
		home.enterMobileNumber(JsonDataManager.readData("AddressDetails", i).get("MobilePhone"));
	}

	@Then("Enter correct name and email address as {int}")
	public void enter_correct_name_and_email_address_as(Integer i) throws IOException, ParseException {
		home.enterLoginEmail(JsonDataManager.readData("userCredentials", i).get("emailAddress"));
		home.enterPassword(JsonDataManager.readData("userCredentials", i).get("password"));
	}

	@Then("Enter incorrect email address and password as {int}")
	public void enter_incorrect_email_address_and_password_as(Integer i) throws IOException, ParseException {
		home.enterLoginEmail(JsonDataManager.readData("userCredentials", i).get("emailAddress"));
		home.enterPassword(JsonDataManager.readData("userCredentials", i).get("password"));
	}

}