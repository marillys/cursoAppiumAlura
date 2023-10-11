package com.alura.appium;

import com.alura.appium.pageObjects.LoginPageObject;
import com.alura.appium.pageObjects.ProdutosPageObject;
import com.alura.appium.steps.CadastroStep;
import com.alura.appium.steps.LoginStep;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeatureLogin {
    @Test
    public void nao_logar_usuario_nao_cadastrado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        LoginStep loginStep = new LoginStep(driver);
        loginStep.logar("Marillys", "123");
        Assertions.assertEquals("Usuário ou senha inválidos", loginStep.obterMensagemErro());
    }

    @Test
    public void logar_usuario_cadastrado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        LoginStep loginStep = new LoginStep(driver);
        CadastroStep cadastroStep = new CadastroStep();
        ProdutosPageObject telaProdutos;

        loginStep.irPraCadastro();
        cadastroStep.cadastrarUsuario("Marillys", "123", "123");

        telaProdutos = loginStep.logar("Marillys", "123");
        telaProdutos.buscarElementos();
    }
}
