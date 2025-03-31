package com.naukri.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import com.naukri.pages.Homepage;
import com.naukri.pages.LoginPage;
import com.naukri.pages.ProfilePage;

import java.util.Arrays;

public class ProfileUpdateTest {
    WebDriver driver;
    LoginPage loginPage;
    Homepage homePage;
    ProfilePage profilePage;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu", "--window-size=1920,1080", "--no-sandbox", "--disable-dev-shm-usage");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.5615.138 Safari/537.36");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);

        //driver.manage().window().maximize();
        driver.get("https://www.naukri.com/");

        loginPage = new LoginPage(driver);
        homePage = new Homepage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    public void LoginTest() {
        String email = System.getenv("NAUKRI_EMAIL");
       String password = System.getenv("NAUKRI_PASSWORD");
//        String email ="arjunmoorthy06@gmail.com";
//        String password ="XperseyNaukri0605$";
        if (email == null || password == null) {
            throw new RuntimeException("Environment variables NAUKRI_EMAIL or NAUKRI_PASSWORD are not set.");
        }

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
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
