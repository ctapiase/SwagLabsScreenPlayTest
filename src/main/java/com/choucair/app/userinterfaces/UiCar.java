package com.choucair.app.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiCar {
    public static final Target CHECKOUT_BUTTON = Target.the("boton de checkout").located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]"));
    public static final Target PRICE_A_PRODUCT = Target.the("boton de checkout").locatedBy(("//android.view.ViewGroup[@content-desc='test-Item'][.//android.widget.TextView[@text='{0}']]//android.view.ViewGroup[@content-desc='test-Precio']/android.widget.TextView\n"));
    public static final Target PRICE_A_PRODUCT_BY_IND = Target.the("boton de checkout").locatedBy(("//android.view.ViewGroup[@content-desc='test-Item'][.//android.widget.TextView[@text='{0}']]//android.view.ViewGroup[@content-desc='test-Precio']/android.widget.TextView\n"));
    public static final Target REMOVE_BY_IND= Target.the("boton de checkout").locatedBy(("(//android.view.ViewGroup[@content-desc=\"test-REMOVER\"])['{0}']"));
    public static final Target REMOVE_BY_NAME= Target.the("boton de checkout").locatedBy(("//android.view.ViewGroup[@content-desc='test-Item' and .//android.widget.TextView[@text='{0}']]//android.view.ViewGroup[@content-desc='test-REMOVER']"));


}
