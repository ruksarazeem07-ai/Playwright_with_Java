package com.pageLocators;

public class HomePageElementsLocators {

	private HomePageElementsLocators() {
	} // prevent object creation

	public static final String USERNAME = "//input[@type='text']";
	public static final String PASSWORD = "//input[@type='password']";
	public static final String Email = "//input[@data-qa='signup-email']";
	public static final String SignUp_LOGIN_Link = "//a[@href='/login']";
	public static String signUpBtn = "//button[@data-qa='signup-button']";
	public static String text1 = "//h2[text()='New User Signup!']";
	public static String text2 = "//b[text()='Enter Account Information']";
	public static String text3 = "//b[text()='Account Created!']";
	public static String text4 = "//a[contains(text(),'Logged in as')]";
	public static String text5 = "//b[text()='Account Deleted!']";
	public static String date = "//select[@id='days']";
	public static String month = "//select[@id='months']";
	public static String years = "//select[@id='years']";
	public static String Title_Mrs = "//span//input[@value='Mrs']";
	public static final String termsCheckbox1 = "//input[@id='newsletter']";
	public static final String termsCheckbox2 = "//input[@id='optin']";
	public static final String FirstName = "//input[@data-qa='first_name']";
	public static final String LastName = "//input[@data-qa='last_name']";
	public static final String Company = "//input[@data-qa='company']";
	public static final String Address1 = "//input[@data-qa='address']";
	public static final String Address2 = "//input[@data-qa='address2']";
	public static final String Country = "//select[@data-qa='country']";
	public static final String State = "//input[@data-qa='state']";
	public static final String City = "//input[@data-qa='city']";
	public static final String Zipcode = "//input[@data-qa='zipcode']";
	public static final String MobileNumber = "//input[@data-qa='mobile_number']";
	public static final String CreateAccountBtn = "//button[@data-qa='create-account']";
	public static final String ContinueBtn = "//a[@data-qa='continue-button']";
	public static final String DeleteAccountBtn = "//a[@href='/delete_account']";
	
}
