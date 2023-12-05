package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class LoginSteps {

    private final WebDriver driver;

    public LoginSteps() {
        // System configuration for the Chrome driver
        String chromeDriverPath = System.getProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        // WebDriver Initialization
        driver = new ChromeDriver();
    }

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        // Implement the navigation to the login page
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        // Implement entering credentials into the username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("I click the login button")
    public void clickLoginButton() {
        // Implement clicking the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    @Then("the URL should be {string}")
    public void verifyURL(String expectedURL) {
        // Implement URL verification
        assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Then("the page should contain {string}")
    public void verifyPageContainsText(String expectedText) {
        // Implement verifying that the page contains the expected text
        assertTrue(driver.findElement(By.tagName("body")).getText().contains(expectedText));
    }

    @Then("the error message should be {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        // Implement verifying the error message
        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        String actualErrorMessage = errorMessage.getText().trim();
        actualErrorMessage = actualErrorMessage.replace("\n", "");

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
