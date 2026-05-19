Feature: Login to the application

  Scenario: 001_Register User
    Given User opens browser and navigate to url
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
    And Click on 'Delete Account' button
    Then Verify that 'ACCOUNT DELETED!' is visible
    And Click on 'Continue' button
