package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public Homepage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Locators
    private By ViewProfile =By.xpath("//a[normalize-space()='View profile']");
    private By Hamberger_Icon =By.xpath("//div[contains(@class, 'nI-gNb-bar2')]");
    private By Logout_Button=By.xpath("//a[normalize-space()='Logout']");

    // Actions with WebDriverWait
    public void ClickProfile(){
        WebElement ViewProfileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ViewProfile));
        ViewProfileElement.click();
    }
    public void ClickHambergerIcon()
    {
        WebElement Hamberger_IconElement =wait.until(ExpectedConditions.elementToBeClickable(Hamberger_Icon));
        Hamberger_IconElement.click();
    }
    public void ClickLogout(){
        WebElement Logout_ButtonElement= wait.until(ExpectedConditions.elementToBeClickable(Logout_Button));
        Logout_ButtonElement.click();
    }



}
