package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;

public abstract class PageObjectsBase {
    protected final AppiumDriver driver;
    protected PageObjectsBase(AppiumDriver driver) {
        this.driver = driver;
    }
    public abstract void buscarElementos();
}
