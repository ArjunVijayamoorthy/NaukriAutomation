package com.naukri.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.naukri.pages.Homepage;
import com.naukri.pages.LoginPage;
import com.naukri.pages.ProfilePage;

public class ProfileUpdateTest {
    WebDriver driver;
    LoginPage loginPage;
    Homepage homePage;
    ProfilePage profilePage;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1080", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);  // Initialize WebDriver

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
