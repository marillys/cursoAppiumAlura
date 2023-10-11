package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject extends PageObjectsBase{

    private MobileElement botaoCadastro;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void buscarElementos() {
        botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    public CadastroPageObjects irTelaCadastro() {
        botaoCadastro.click();

        return new CadastroPageObjects(driver);
    }
}
