package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObjects extends PageObjectsBase {
    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement labelErro;

    private final By erroID;
    private final By campoNomeID;
    private final By campoSenhaID;
    private final By campoConfirmacaoID;
    private final By botaoCadastrarID;

    public CadastroPageObjects(AppiumDriver driver) {
        super(driver);
        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmacaoID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrarID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void buscarElementos() {
        campoNome = (MobileElement) driver.findElement(campoNomeID);
        campoSenha = (MobileElement) driver.findElement(campoSenhaID);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmacaoID);
        botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarID);
    }

    private void preencherCampos(String nome, String senha, String confirmarSenha) {
        campoNome.sendKeys(nome);
        campoSenha.sendKeys(senha);
        campoConfirmarSenha.sendKeys(confirmarSenha);
    }

    public LoginPageObject cadastrar(String nome, String senha, String confirmarSenha) {
        preencherCampos(nome, senha, confirmarSenha);
        botaoCadastrar.click();

        return new LoginPageObject(driver);
    }

    public String mensagemErro() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroID));
        labelErro = (MobileElement) driver.findElement(erroID);
        return labelErro.getText();
    }
}
