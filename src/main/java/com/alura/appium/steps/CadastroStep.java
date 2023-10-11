package com.alura.appium.steps;

import com.alura.appium.AppiumDriverConfig;
import com.alura.appium.pageObjects.CadastroPageObjects;
import com.alura.appium.pageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;

public class CadastroStep {
    public LoginPageObject cadastrarUsuario(String usuario, String senha, String confirmacaoSenha) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CadastroPageObjects telaCadastro = new CadastroPageObjects(driver);
        telaCadastro.buscarElementos();
        return telaCadastro.cadastrar(usuario, senha, confirmacaoSenha);
    }
}
