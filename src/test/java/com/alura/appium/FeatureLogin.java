package com.alura.appium;

import com.alura.appium.pageObjects.LoginPageObject;
import com.alura.appium.pageObjects.ProdutosPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeatureLogin {
    @Test
    public void nao_logar_usuario_nao_cadastrado()
    {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        LoginPageObject telaLogin = new LoginPageObject(driver);
        ProdutosPageObject telaProdutos;
        telaLogin.buscarElementos();
        telaLogin.logar("Marillys","123");
        Assertions.assertEquals("Usuário ou senha inválidos",telaLogin.mensagemErro());
    }
}
