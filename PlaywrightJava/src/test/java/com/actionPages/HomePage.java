package com.actionPages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;

import com.dataManager.JsonDataManager;
import com.microsoft.playwright.Page;
import com.pageLocators.HomePageElementsLocators;

import Base.BasePage;
import Base.CommonMethods;
import utils.ConfigConstants;

public class HomePage extends BasePage {

	private Page page;
	private CommonMethods common;

	// Create object in constructor
	public HomePage(Page page) {
		this.page = page;
		this.common = new CommonMethods(page); // object created here
	}

	public void verifyLoginPageLoaded() {
		assertTrue("Login button not visible. Page not loaded",
				isElementPresent(HomePageElementsLocators.SignUp_LOGIN_Link));
	}

	public void enterUsername(String username) {
		try {
			page.waitForSelector(HomePageElementsLocators.USERNAME);
			type(HomePageElementsLocators.USERNAME, username);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to enter name" + e);
		}
	}

	public void enterPassword(String password) {
		try {
			page.waitForSelector(HomePageElementsLocators.PASSWORD);
			type(HomePageElementsLocators.PASSWORD, password);
		} catch (Exception e) {

			Assert.fail("Unable to enter password " + e);

		}
	}

	public void enterSiginUpEmail(String email) {
		try {
			page.waitForSelector(HomePageElementsLocators.Email);
			type(HomePageElementsLocators.Email, email);
		} catch (Exception e) {

			Assert.fail("Unable to enter EmailAddress " + e);

		}
	}
	
	public void enterLoginEmail(String email) {
		try {
			page.waitForSelector(HomePageElementsLocators.loginMail);
			type(HomePageElementsLocators.loginMail, email);
		} catch (Exception e) {

			Assert.fail("Unable to enter EmailAddress " + e);

		}
	}

	public void enterFirstName(String FirstName) {
		try {
			page.waitForSelector(HomePageElementsLocators.FirstName);
			type(HomePageElementsLocators.FirstName, FirstName);
		} catch (Exception e) {

			Assert.fail("Unable to enter FirstName " + e);

		}
	}

	public void enterLastName(String LastName) {
		try {
			page.waitForSelector(HomePageElementsLocators.LastName);
			type(HomePageElementsLocators.LastName, LastName);
		} catch (Exception e) {

			Assert.fail("Unable to enter LastName " + e);

		}
	}

	public void enterCompany(String Company) {
		try {
			page.waitForSelector(HomePageElementsLocators.Company);
			type(HomePageElementsLocators.Company, Company);
		} catch (Exception e) {

			Assert.fail("Unable to enter Company " + e);

		}
	}

	public void enterAddress1(String Address1) {
		try {
			page.waitForSelector(HomePageElementsLocators.Address1);
			type(HomePageElementsLocators.Address1, Address1);
		} catch (Exception e) {

			Assert.fail("Unable to enter Address1 " + e);

		}
	}

	public void enterAddress2(String Address2) {
		try {
			page.waitForSelector(HomePageElementsLocators.Address2);
			type(HomePageElementsLocators.Address2, Address2);
		} catch (Exception e) {

			Assert.fail("Unable to enter Address2 " + e);

		}
	}

	public void enterState(String State) {
		try {
			page.waitForSelector(HomePageElementsLocators.State);
			type(HomePageElementsLocators.State, State);
		} catch (Exception e) {

			Assert.fail("Unable to enter State " + e);

		}
	}

	public void enterCity(String City) {
		try {
			page.waitForSelector(HomePageElementsLocators.City);
			type(HomePageElementsLocators.City, City);
		} catch (Exception e) {

			Assert.fail("Unable to enter City " + e);

		}
	}

	public void enterZipcode(String Zipcode) {
		try {
			page.waitForSelector(HomePageElementsLocators.Zipcode);
			type(HomePageElementsLocators.Zipcode, Zipcode);
		} catch (Exception e) {

			Assert.fail("Unable to enter Zipcode " + e);

		}
	}

	public void enterMobileNumber(String MobileNumber) {
		try {
			page.waitForSelector(HomePageElementsLocators.MobileNumber);
			type(HomePageElementsLocators.MobileNumber, MobileNumber);
		} catch (Exception e) {

			Assert.fail("Unable to enter MobileNumber " + e);

		}
	}

//	public void selectCountry() {
//		try {
//			page.waitForSelector(HomePageElementsLocators.Country);
//			Map<String, String> AddressDetails = JsonDataManager.readData("AddressDetails", 0);
//			String Country = AddressDetails.get("Country");
//			common.selectOption(HomePageElementsLocators.Country, Country);
//			
//		} catch (Exception e) {
//
//			Assert.fail("Unable to select Country " + e);
//
//		}
//	}

	public void selectCountry() {
		try {
			Map<String, String> AddressDetails = JsonDataManager.readData("AddressDetails", 0);
			String Country = AddressDetails.get("Country");

			// Debug — print all available options
			List<String> options = page.locator(HomePageElementsLocators.Country).locator("option").allInnerTexts();
			System.out.println("Available options: " + options);
			System.out.println("Trying to select: " + Country);

			common.selectOption(HomePageElementsLocators.Country, Country);

		} catch (Exception e) {
			Assert.fail("Unable to select Country " + e);
		}
	}

	public void clickOnLoginLink() {
		try {
			page.waitForSelector(HomePageElementsLocators.SignUp_LOGIN_Link);
			click(HomePageElementsLocators.SignUp_LOGIN_Link);
		} catch (Exception e) {

			Assert.fail("Unable to click on button" + e);
		}
	}
	
	public void clickOnLogin() {
		try {
			page.waitForSelector(HomePageElementsLocators.LoginBtn);
			click(HomePageElementsLocators.LoginBtn);
		} catch (Exception e) {

			Assert.fail("Unable to click on button" + e);
		}
	}

	public void clickOnCreateAccountButton() {
		try {
			page.waitForSelector(HomePageElementsLocators.CreateAccountBtn);
			click(HomePageElementsLocators.CreateAccountBtn);
		} catch (Exception e) {

			Assert.fail("Unable to click on button" + e);
		}
	}

	public void clickContinueButton() {
		try {
			page.waitForSelector(HomePageElementsLocators.ContinueBtn);
			click(HomePageElementsLocators.ContinueBtn);
		} catch (Exception e) {

			Assert.fail("Unable to click on button" + e);
		}
	}

	public void clickDeleteAccountButton() {
		try {
			page.waitForSelector(HomePageElementsLocators.DeleteAccountBtn);
			click(HomePageElementsLocators.DeleteAccountBtn);
		} catch (Exception e) {

			Assert.fail("Unable to click on button" + e);
		}
	}

	public void verifyText(String text) {
		try {
			if (text.contains(ConfigConstants.text1)) {
				page.waitForSelector(HomePageElementsLocators.text1);

				// Get actual text from the element
				String actualText = page.locator(HomePageElementsLocators.text1).innerText();

				// Assert both texts match
				Assert.assertEquals("Text mismatch!", text, actualText.trim());

				// Assert element is visible
				assertThat(page.locator(HomePageElementsLocators.text1)).isVisible();

				System.out.println("Expected: " + text + " | Actual: " + actualText);
			} else if (text.contains(ConfigConstants.text2)) {
				page.waitForSelector(HomePageElementsLocators.text2);

				// Get actual text from the element
				String actualText = page.locator(HomePageElementsLocators.text2).innerText();

				// Assert both texts match
				Assert.assertEquals("Text mismatch!", text, actualText.trim());

				// Assert element is visible
				assertThat(page.locator(HomePageElementsLocators.text2)).isVisible();

				System.out.println("Expected: " + text + " | Actual: " + actualText);
			} else if (text.contains(ConfigConstants.text6)) {
				page.waitForSelector(HomePageElementsLocators.text3);

				// Get actual text from the element
				String actualText = page.locator(HomePageElementsLocators.text3).innerText();

				// Assert both texts match
				Assert.assertEquals("Text mismatch!", text, actualText.trim());

				// Assert element is visible
				assertThat(page.locator(HomePageElementsLocators.text3)).isVisible();

				System.out.println("Expected: " + text + " | Actual: " + actualText);
			} else if (text.contains(ConfigConstants.text7)) {
				page.waitForSelector(HomePageElementsLocators.text4);

				String actualText = page.locator(HomePageElementsLocators.text4).innerText();

				// Check if actual text CONTAINS expected text (not full match)
				// because page shows "Logged in as Ruksar" but text4 is " Logged in as "
				Assert.assertTrue("Text mismatch! Expected to contain: " + text + " | Actual: " + actualText,
						actualText.contains(text.trim()));

				assertThat(page.locator(HomePageElementsLocators.text4)).isVisible();
				System.out.println("Expected: " + text + " | Actual: " + actualText);
			} else if (text.contains(ConfigConstants.text8)) {
				page.waitForSelector(HomePageElementsLocators.text5);
				String actualText = page.locator(HomePageElementsLocators.text5).innerText();
				Assert.assertEquals("Text mismatch!", text, actualText.trim());
				assertThat(page.locator(HomePageElementsLocators.text5)).isVisible();
				System.out.println("Expected: " + text + " | Actual: " + actualText);
			} else if (text.contains(ConfigConstants.text9)){
				page.waitForSelector(HomePageElementsLocators.text6);
				String actualText = page.locator(HomePageElementsLocators.text6).innerText();
				Assert.assertEquals("Text mismatch!", text, actualText.trim());
				assertThat(page.locator(HomePageElementsLocators.text6)).isVisible();
				System.out.println("Expected: " + text + " | Actual: " + actualText);
			}else {
				Assert.fail("Text not recognized: " + text);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Text not visible or mismatch: " + e.getMessage());
		}
	}

	public void clickSignUpButton() {
		try {
			page.locator(HomePageElementsLocators.signUpBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Button not clickable: " + e.getMessage());
		}
	}

	public void selectDateOfBirth() {
		try {
			Map<String, String> dobData = JsonDataManager.readData("dateOfBirth", 0);

			String day = dobData.get("day");
			String month = dobData.get("month");
			String year = dobData.get("year");

			common.selectOption(HomePageElementsLocators.date, day);
			common.selectOption(HomePageElementsLocators.month, month);
			common.selectOption(HomePageElementsLocators.years, year);

			System.out.println("DOB selected: " + day + "-" + month + "-" + year);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to select Date of Birth: " + e.getMessage());
		}
	}

	public void selectTitle() {
		try {
//	        Map<String, String> regData = JsonDataManager.readData("RegistrationDetails", 0);
//	        String title = regData.get("Title");
			common.click(HomePageElementsLocators.Title_Mrs);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to select Title: " + e.getMessage());
		}
	}

	public void CheckBox(String Text) {
		try {
			if (Text.contains(ConfigConstants.CheckBox1)) {
				common.clickCheckbox(HomePageElementsLocators.termsCheckbox1);
				System.out.println("Checkbox clicked successfully");
			} else if (Text.contains(ConfigConstants.CheckBox2)) {
				common.clickCheckbox(HomePageElementsLocators.termsCheckbox2);
				System.out.println("Checkbox clicked successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}

	}

}
