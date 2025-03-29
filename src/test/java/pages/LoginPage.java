package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default explicit wait
    }

    // Locators
    private By loginlink = By.id("login_Layer");
    private By Username = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
    private By Password = By.xpath("//input[@placeholder='Enter your password']");
    private By LoginButton = By.xpath("//button[normalize-space()='Login']");

    // Actions with WebDriverWait
    public void Click_loginlink() {
        WebElement loginLinkElement = wait.until(ExpectedConditions.elementToBeClickable(loginlink));
        loginLinkElement.click();
    }
    public void Enter_Username(String UserName) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
        usernameField.sendKeys(UserName);
    }
    public void Enter_Password(String passWord) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
        passwordField.sendKeys(passWord);
    }
    public void Click_LoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
        loginButtonElement.click();
    }
}
