package com.naukri.tests;

import com.naukri.pages.TestBase;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import com.naukri.pages.Homepage;
import com.naukri.pages.LoginPage;
import com.naukri.pages.ProfilePage;

import java.util.Arrays;

public class ProfileUpdateTest extends TestBase {
    WebDriver driver;
    LoginPage loginPage;
    Homepage homePage;
    ProfilePage profilePage;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        // Comment out --headless to debug
        options.addArguments("--disable-gpu", "--window-size=1920,1080", "--no-sandbox", "--disable-dev-shm-usage");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.5615.138 Safari/537.36");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);  // Initialize driver first
        driver.get("https://www.naukri.com/");

        // Adding cookies **after** initializing WebDriver
        driver.manage().addCookie(new Cookie("cookie_name", "cookie_value"));

        loginPage = new LoginPage(driver);
        homePage = new Homepage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    public void LoginTest() {
        String email = System.getenv("NAUKRI_EMAIL");
        String password = System.getenv("NAUKRI_PASSWORD");

        if (email == null || password == null) {
            throw new RuntimeException("Environment variables NAUKRI_EMAIL or NAUKRI_PASSWORD are not set.");
        }
        try {
        loginPage.Click_loginlink();
        loginPage.Enter_Username(email);
        loginPage.Enter_Password(password);
        loginPage.Click_LoginButton();

        homePage.ClickProfile();
        profilePage.ClickEditProfile();
        profilePage.ClearEditLocation();
        profilePage.ChooseLocation();
        profilePage.ClickSave();

        homePage.ClickHambergerIcon();
        homePage.ClickLogout();
        } catch (Exception e) {
            captureScreenshot("LoginTest"); // Call captureScreenshot from TestBase
            e.printStackTrace();
            throw e;
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
