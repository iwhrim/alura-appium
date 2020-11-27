package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPageObject extends PageObjectBase {

    private MobileElement nameInput;
    private MobileElement passwordInput;
    private MobileElement confirmPasswordInput;
    private MobileElement confirmRegisterButton;

    private final By messageErrorElementId;
    private final By nameInputId;
    private final By passwordInputId;
    private final By confirmPasswordInputId;
    private final By confirmRegisterButtonId;

    public RegisterPageObject(AppiumDriver driver) {
        super(driver);

        messageErrorElementId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        nameInputId = By.id("br.com.alura.aluraesporte:id/input_nome");
        passwordInputId = By.id("br.com.alura.aluraesporte:id/input_senha");
        confirmPasswordInputId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        confirmRegisterButtonId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");

    }

    @Override
    public void findElements() {
        nameInput = (MobileElement) driver.findElement(nameInputId);
        passwordInput = (MobileElement) driver.findElement(passwordInputId);
        confirmPasswordInput = (MobileElement) driver.findElement(confirmPasswordInputId);
        confirmRegisterButton = (MobileElement) driver.findElement(confirmRegisterButtonId);
    }

    public LoginPageObject register(String nameInput, String passwordInput, String confirmPasswordInput) {
        this.nameInput.setValue(nameInput);
        this.passwordInput.setValue(passwordInput);
        this.confirmPasswordInput.setValue(confirmPasswordInput);
        this.confirmRegisterButton.click();
        return new LoginPageObject(this.driver);
    }

    public String getErrorMessage() {
        WebDriverWait delay = new WebDriverWait(driver, 2);
        delay.until(ExpectedConditions.presenceOfElementLocated(messageErrorElementId));

        return driver.findElement(messageErrorElementId).getText();
    }
}
