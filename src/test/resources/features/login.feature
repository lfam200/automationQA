Feature: Login Functionality

  Scenario: Successful Login
    Given I am on the login page
    When I enter username "tomsmith" and password "SuperSecretPassword!"
    And I click the login button
    Then the URL should be "https://the-internet.herokuapp.com/secure"
    And the page should contain "Welcome to the Secure Area"

  Scenario: Invalid Username
    Given I am on the login page
    When I enter username "incorrect" and password "SuperSecretPassword!"
    And I click the login button
    Then the error message should be "Your username is invalid!×"

  Scenario: Invalid Password
    Given I am on the login page
    When I enter username "tomsmith" and password "incorrect"
    And I click the login button
    Then the error message should be "Your password is invalid!×"
