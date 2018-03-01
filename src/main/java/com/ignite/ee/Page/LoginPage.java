package com.ignite.ee.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
    ChromeDriver webDriver;
    //WebElements
    @FindBy(name = "username")
    @CacheLookup
    private WebElement username;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(name = "submit")
    @CacheLookup
    private WebElement submit;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement newPassword;

    @FindBy(name = "confirmPassword")
    @CacheLookup
    private WebElement confirmPassword;

    @FindBy(name = "change")
    @CacheLookup
    private WebElement changeBtn;

    @FindBy(name = "username")
    @CacheLookup
    private WebElement newusername;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement newpassword;

    @FindBy(id = "pswError")
    @CacheLookup
    private WebElement pswError;


    public LoginPage() {
        this.webDriver= webDriver;
        PageFactory.initElements((WebDriver) this.webDriver, this);
    }

    //Methods
    public LoginPage login(String uName, String passw){
        username.sendKeys(uName);
        password.sendKeys(passw);
        submit.click();
        return this;
    }

    public LoginPage changePassword(String nPassw, String cPassw){
        newPassword.sendKeys(nPassw);
        confirmPassword.sendKeys(cPassw);
        changeBtn.click();
        return this;
    }

    public LoginPage getPasswordErrorMessage(){
        pswError.getText();
        return this;
    }
}
