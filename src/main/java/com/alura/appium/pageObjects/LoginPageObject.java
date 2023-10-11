package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends PageObjectsBase {

    private MobileElement botaoCadastro;
    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement botaoLogar;
    private MobileElement labelErro;

    private final By botaoCadastroID;
    private final By campoUsuarioID;
    private final By campoSenhaID;
    private final By botaoLogarID;
    private final By erroID;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
        botaoCadastroID = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        campoUsuarioID = By.id("br.com.alura.aluraesporte:id/input_usuario");
        campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        botaoLogarID = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
        erroID = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");
    }

    @Override
    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(botaoCadastroID));

        botaoCadastro = (MobileElement) driver.findElement(botaoCadastroID);
        campoUsuario = (MobileElement) driver.findElement(campoUsuarioID);
        campoSenha = (MobileElement) driver.findElement(campoSenhaID);
        botaoLogar = (MobileElement) driver.findElement(botaoLogarID);
    }

    public CadastroPageObjects irTelaCadastro() {
        botaoCadastro.click();

        return new CadastroPageObjects(driver);
    }

    private void preencherCampos(String usuario, String senha) {
        campoUsuario.sendKeys(usuario);
        campoSenha.sendKeys(senha);
    }

    public ProdutosPageObject logar(String usuario, String senha) {
        preencherCampos(usuario, senha);
        botaoLogar.click();

        return new ProdutosPageObject(driver);
    }

    public String mensagemErro() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroID));
        labelErro = (MobileElement) driver.findElement(erroID);
        return labelErro.getText();
    }
}
