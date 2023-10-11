package com.alura.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {
    public final AppiumDriver<MobileElement> driver;
    private static AppiumDriverConfig _instance;
    public static AppiumDriverConfig Instance()
    {
        if(AppiumDriverConfig._instance == null){
            AppiumDriverConfig._instance = new AppiumDriverConfig();
        }
        return AppiumDriverConfig._instance;
    }
    private AppiumDriverConfig() {
        DesiredCapabilities configuracoes = new DesiredCapabilities();
        File apk = new File("D:\\Users\\London\\Documents\\Projetos\\AluraAppium\\src\\main\\resources\\alura_esporte.apk");

        configuracoes.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        URL urlConexao = null;
        try {
            urlConexao = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AppiumDriver<MobileElement>(urlConexao, configuracoes);
    }
}