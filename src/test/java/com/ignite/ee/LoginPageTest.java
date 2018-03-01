package com.ignite.ee;

import com.ignite.ee.Page.LoginPage;
import com.ignite.ee.Database.UpdateTables;
import com.ignite.ee.util.PropertyLoader;
import com.ignite.ee.webdriver.DriverManager;
import com.ignite.ee.webdriver.DriverManagerFactory;
import com.ignite.ee.webdriver.DriverType;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;


public class LoginPageTest extends UpdateTables {

    private LoginPage loginpage;

    private DriverManager driverManager;

    private WebDriver driver;

    @Before
    public void testInit(){
        String applicationUrl = PropertyLoader.loadProperty("application.url");
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.navigate().to(applicationUrl);
        loginpage = PageFactory.initElements(driver, LoginPage.class);
    }


    @After
    public void afterMethod() {
        driverManager.quitDriver();
        UpdateAuthoritiesTable();
        UpdateUsersTable();
    }


    @Features("Login Page")
    @TestCaseId("1")
    @Test
    public void sucessfulLoginTest(){
        String uName="Jake";
        String passw="Jake";
        loginpage.login(uName, passw);
        String assertLoginText = driver.findElement(By.xpath("/html/body/header/div/p")).getText();

        Assert.assertEquals(
                assertLoginText,
                "Welcome " + uName +"!"+" Logout" );
    }

    @Features("Login Page")
    @TestCaseId("3")
    @Test
    public void wrongUsernameLoginTest(){
        loginpage.login("Jake1", "Jake");
        String assertLoginText = driver.findElement(By.xpath("//*[@id='login-box']/form/div")).getText();

        Assert.assertEquals(
                assertLoginText,
                "Invalid username or password!" );
    }

    @Features("Login Page")
    @TestCaseId("4")
    @Test
    public void wrongPasswordLoginTest(){
        loginpage.login("Jake", "Jake1");
        String assertLoginText = driver.findElement(By.xpath("//*[@id='login-box']/form/div")).getText();

        Assert.assertEquals(
                assertLoginText,
                "Invalid username or password!" );
    }

    @Features("Login Page")
    @TestCaseId("6")
    @Test
    public void newUserForcedToChangePassword(){
        String uName = "Tom";
        String passwd = "Tom";
        loginpage.login(uName, passwd);

        String passwordChangeForm = driver.findElement(By.xpath("//*[@id=\"password-change-box\"]/form/h2")).getText();
        String passwordChangeText = driver.findElement(By.xpath("//*[@id=\"password-change-box\"]/form/div[1]")).getText();

        Assert.assertEquals(
                passwordChangeForm,
                "Change password" );
        Assert.assertEquals(passwordChangeText, "Password change is needed on first login!");
    }

    @Features("Login Page")
    @TestCaseId("6")
    @Test
    public void changePasswordOnFirstLoginAndUseNewPassword(){
        String uName = "Sara";
        String passwd = "Sara";
        String newPasswd = "SaraNew";
        loginpage.login(uName, passwd);
        loginpage.changePassword(newPasswd, newPasswd);

        String assertLoginText = driver.findElement(By.xpath("//*[@id=\"login-box\"]/form/h2")).getText();

        Assert.assertEquals(
                assertLoginText,
                "Please sign in" );
    }

    //TODO needs to resolve "stale element reference: element is not attached to the page document" error to relogin
    //TODO with new passowrd.
    @Features("Login Page")
    @TestCaseId("7")
    @Test
    public void changePasswordOnFirstLoginAndUseSameOldPassword(){
        loginpage.login("Tom", "Tom");
        loginpage.changePassword("Tom", "Tom");
    }

    @Features("Login Page")
    @TestCaseId("5")
    @Test
    public void changePasswordOnFirstLoginAndInsertNoPassword(){
        loginpage.login("Tom", "Tom");
        loginpage.changePassword(" ", " ");
    }

    @Features("Login Page")
    @TestCaseId("9")
    @Test
    public void changePasswordOnFirstLoginAndUseTooLongPassword(){
        loginpage.login("Tom", "Tom");
        loginpage.changePassword("TomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTom",
                "TomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTom");
    }

    @Features("Login Page")
    @TestCaseId("13")
    @Test
    public void changePasswordOnFirstLoginAndPasswordMismatch(){
        loginpage.login("Tom", "Tom");
        loginpage.changePassword("TomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTom",
                "TomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTomTom");
        String errorMessage = driver.findElement(By.id("pswError")).getText();

        Assert.assertEquals(errorMessage, "Passwords do not match!");
    }


}
