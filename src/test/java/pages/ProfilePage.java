package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public ProfilePage(WebDriver driver){
        this.driver=driver;
        this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Locators
    By EditProfile= By.xpath("//em[@class='icon edit ']");
    By EditLocation =By.xpath("//input[@id='locationSugg']");
    By ClickLocation =By.xpath("//li[normalize-space()='Bengaluru']");
    By SaveBtn=By.xpath("//button[@id='saveBasicDetailsBtn']");

    // Actions with WebDriverWait
    public void ClickEditProfile(){
        WebElement ClickProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(EditProfile));
        ClickProfile.click();
    }
    public void ClearEditLocation(){
        WebElement ClearLocation =wait.until(ExpectedConditions.visibilityOfElementLocated(EditLocation));
        ClearLocation.clear();
    }
    public void ChooseLocation(){
        WebElement Location =wait.until(ExpectedConditions.elementToBeClickable(ClickLocation));
        Location.click();
    }
    public void ClickSave(){
        WebElement Savebutton= wait.until(ExpectedConditions.elementToBeClickable(SaveBtn));
        Savebutton.click();
    }

}
