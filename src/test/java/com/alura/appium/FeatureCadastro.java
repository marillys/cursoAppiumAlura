package com.alura.appium;

import com.alura.appium.pageObjects.CadastroPageObjects;
import com.alura.appium.pageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class FeatureCadastro {
    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();
        CadastroPageObjects telaCadastro = telaLogin.irTelaCadastro();
        telaCadastro.buscarElementos();
        telaCadastro.cadastrar("Marillys", "123", "456");
        Assertions.assertEquals("Senhas não conferem", telaCadastro.mensagemErro());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuarios_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();
        CadastroPageObjects telaCadastro = telaLogin.irTelaCadastro();
        telaCadastro.buscarElementos();
        telaLogin = telaCadastro.cadastrar("Marillys", "123", "123");
        telaLogin.buscarElementos();
    }

    @Test
    public void nao_cadastrar_usuario_com_dados_ja_utilizados_por_outro_usuario()
    {
        posso_cadastrar_usuarios_com_senhas_que_conferem();

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.buscarElementos();
        CadastroPageObjects telaCadastro = telaLogin.irTelaCadastro();
        telaCadastro.buscarElementos();
        telaCadastro.cadastrar("Marillys", "123", "123");
        Assertions.assertEquals("Usuario já Cadastrado", telaCadastro.mensagemErro());
        driver.navigate().back();
    }
}
