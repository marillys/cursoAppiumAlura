package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class ProdutosPageObject extends PageObjectsBase {
    private MobileElement botaoProdutos;

    private final By botaoProdutosID;

    public ProdutosPageObject(AppiumDriver driver) {
        super(driver);
        botaoProdutosID = By.id("br.com.alura.aluraesporte:id/listaProdutos");
    }

    @Override
    public void buscarElementos() {
        botaoProdutos = (MobileElement) driver.findElement(botaoProdutosID);
    }
}
