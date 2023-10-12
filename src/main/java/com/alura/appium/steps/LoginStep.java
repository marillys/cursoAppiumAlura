package com.alura.appium.steps;

import com.alura.appium.pageObjects.CadastroPageObjects;
import com.alura.appium.pageObjects.LoginPageObject;
import com.alura.appium.pageObjects.ProdutosPageObject;
import io.appium.java_client.AppiumDriver;

public class LoginStep {
    AppiumDriver driver;
    LoginPageObject telaLogin;

    public LoginStep(AppiumDriver driver) {
        this.driver = driver;
        telaLogin = new LoginPageObject(driver);
    }

    public CadastroPageObjects irPraCadastro() {
        telaLogin.buscarElementos();
        return telaLogin.irTelaCadastro();
    }

    public ProdutosPageObject logar(String usuario, String senha) {
        telaLogin.buscarElementos();
        return telaLogin.logar(usuario, senha);
    }

    public String obterMensagemErro() {
        return telaLogin.mensagemErro();
    }

    public void consultarElementos() {
        telaLogin.buscarElementos();
    }
}
