package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Homepage;
import pages.LoginPage;
import pages.ProfilePage;
public class ProfileUpdateTest {
    WebDriver driver;
    LoginPage loginPage;
    Homepage Homepage;
    ProfilePage ProfilePage;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com/");
        loginPage = new LoginPage(driver);
        Homepage = new Homepage(driver);
        ProfilePage = new ProfilePage(driver);
    }
    @Test
    public void LoginTest() throws InterruptedException {

        loginPage.Click_loginlink();
        loginPage.Enter_Username("arjunmoorthy06@gmail.com");
        loginPage.Enter_Password("XperseyNaukri0605$");
        loginPage.Click_LoginButton();
        Homepage.ClickProfile();
        ProfilePage.ClickEditProfile();
        ProfilePage.ClearEditLocation();
        ProfilePage.ChooseLocation();
        ProfilePage.ClickSave();
        Homepage.ClickHambergerIcon();
        Homepage.ClickLogout();
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
