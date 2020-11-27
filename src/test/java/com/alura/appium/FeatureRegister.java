package com.alura.appium;

import static org.junit.Assert.assertEquals;

import com.alura.appium.PageObjects.LoginPageObject;
import com.alura.appium.PageObjects.RegisterPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Test;


public class FeatureRegister {

    AppiumDriver driver = AppiumDriverConfig.Instace().driver;

    @Test
    public void shouldNotRegisterUserWithPasswordsThatDoNotCheck() {
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.findElements();

        RegisterPageObject registerPage = loginPageObject.nagivateToRegisterPage();;
        registerPage.findElements();
        registerPage.register("User", "123", "321");

        assertEquals("Senhas não conferem", registerPage.getErrorMessage());
        driver.navigate().back();
    }gu

    @Test
    public void shouldRegisterUserWithPasswordsThatCheck() {
        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.findElements();

        RegisterPageObject registerPage = loginPage.nagivateToRegisterPage();;
        registerPage.findElements();
        LoginPageObject loginPageReturned = registerPage.register("User", "123", "123");
        loginPageReturned.findElements();
    }

}
