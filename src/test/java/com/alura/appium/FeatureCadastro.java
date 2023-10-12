package com.alura.appium;

import com.alura.appium.steps.CadastroStep;
import com.alura.appium.steps.LoginStep;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class FeatureCadastro {
    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginStep loginStep = new LoginStep(driver);
        CadastroStep cadastroStep = new CadastroStep(driver);

        loginStep.irPraCadastro();
        cadastroStep.cadastrarUsuario("Marillys", "123", "456");
        Assertions.assertEquals("Senhas não conferem", cadastroStep.obterMensagemErro());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuarios_com_senhas_que_conferem() throws NoSuchElementException {
        String usuario = "Usuario";
        String senha = "abc";

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginStep loginStep = new LoginStep(driver);
        CadastroStep cadastroStep = new CadastroStep(driver);

        loginStep.irPraCadastro();
        cadastroStep.cadastrarUsuario(usuario, senha, senha);

        loginStep.consultarElementos();
    }

    @Test
    public void nao_cadastrar_usuario_com_dados_ja_utilizados_por_outro_usuario() {
        String usuario = "Usuario2";
        String senha = "abc";


        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        LoginStep loginStep = new LoginStep(driver);
        CadastroStep cadastroStep = new CadastroStep(driver);

        loginStep.irPraCadastro();
        cadastroStep.cadastrarUsuario(usuario, senha, senha);

        loginStep.irPraCadastro();
        cadastroStep.cadastrarUsuario(usuario, senha, senha);

        Assertions.assertEquals("Usuario já Cadastrado", cadastroStep.obterMensagemErro());
        driver.navigate().back();
    }
}
