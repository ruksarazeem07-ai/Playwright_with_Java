Feature: Login to the application

  Background:
    Given User opens browser and navigate to url

  Scenario: 001_Register User
    Then Verify that home page is visible successfully
    When Click on 'Signup / Login' button
    Then Verify that 'New User Signup!' is visible
    Then Enter name and email address as 0
    And Click on 'Signup' button
    Then Verify that 'ENTER ACCOUNT INFORMATION' is visible
    When Fill Registration details as 0
    And Select checkbox 'Sign up for our newsletter!'
    And Select checkbox 'Receive special offers from our partners!'
    And Fill Address details as 0
    Then Click on 'Create Account button' button
    And Verify that 'ACCOUNT CREATED!' is visible
    And Click on 'Continue' button
    Then Verify that ' Logged in as ' is visible
    #And Click on 'Delete Account' button
    Then Verify that 'ACCOUNT DELETED!' is visible
    And Click on 'Continue' button


  Scenario: 002_Login_User_with_correct_email_and_password
    Then Verify that home page is visible successfully
    When Click on 'Signup / Login' button
    Then Verify that 'Login to your account' is visible
    Then Enter correct name and email address as 1
    And Click on 'login' button
    Then Verify that ' Logged in as ' is visible

  Scenario: 003_Login_User_with_incorrect_email_and_password
    Then Verify that home page is visible successfully
    When Click on 'Signup / Login' button
    Then Verify that 'Login to your account' is visible
    Then Enter incorrect email address and password as 2
    And Click on 'login' button
    Then Verify that 'Your email or password is incorrect!' is visible