package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject extends PageObjectBase {

    private MobileElement registerButton;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
    }


    @Override
    public void findElements() {
        registerButton = (MobileElement) driver
                .findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    public RegisterPageObject nagivateToRegisterPage() {
        registerButton.click();
        return new RegisterPageObject(this.driver);
    }


}
