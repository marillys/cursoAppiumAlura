package com.alura.appium.steps;

import com.alura.appium.pageObjects.CadastroPageObjects;
import com.alura.appium.pageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;

public class CadastroStep {
    AppiumDriver driver;
    CadastroPageObjects telaCadastro;

    public CadastroStep(AppiumDriver driver) {
        this.driver = driver;
        telaCadastro = new CadastroPageObjects(driver);
    }

    public LoginPageObject cadastrarUsuario(String usuario, String senha, String confirmacaoSenha) {
        telaCadastro.buscarElementos();
        return telaCadastro.cadastrar(usuario, senha, confirmacaoSenha);
    }

    public String obterMensagemErro() {
        return telaCadastro.mensagemErro();
    }
}
