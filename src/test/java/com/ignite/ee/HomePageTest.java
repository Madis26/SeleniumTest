package com.ignite.ee;

import com.ignite.ee.Page.HomePage;
import com.ignite.ee.Page.LoginPage;
import com.ignite.ee.Database.UpdateTables;
import com.ignite.ee.util.PropertyLoader;
import com.ignite.ee.webdriver.DriverManager;
import com.ignite.ee.webdriver.DriverManagerFactory;
import com.ignite.ee.webdriver.DriverType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.sql.SQLException;

public class HomePageTest extends UpdateTables{
    LoginPage loginpage;
    HomePage homePage;

    DriverManager driverManager;
    WebDriver driver;

    @Before
    public void testInit() throws SQLException {
        String applicationUrl = PropertyLoader.loadProperty("application.url");
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = (WebDriver) driverManager.getDriver();
        driver.navigate().to(applicationUrl);
        loginpage = PageFactory.initElements(driver, LoginPage.class);
    }

   @After
   public void afterMethod() {
        driverManager.quitDriver();
        UpdateAuthoritiesTable();
        UpdateUsersTable();
   }

    @Features("Home Page")
    @TestCaseId("2")
    @Test
    public void successfulLogoutTest(){
        loginpage.login("Jake", "Jake");
        WebElement kkk = driver.findElement(By.xpath("/html/body/header/div/p/a"));
        kkk.click();

        String assertLogOut = driver.findElement(By.xpath("//*[@id=\"login-box\"]/form/div")).getText();

        Assert.assertEquals(assertLogOut, "You've been logged out successfully.");
    }

    @Features("Home Page")
    @TestCaseId("12")
    @Test
    public void succsessfulLoginUserCanViewAccountBalance() throws InterruptedException {
        loginpage.login("Jake", "Jake");

        String accountBalance1 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[2]")).getText();
        String accountBalance2 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]")).getText();

        Assert.assertEquals(accountBalance1, "200.0 EUR");
        Assert.assertEquals(accountBalance2, "3020.0 EUR");

    }
}
