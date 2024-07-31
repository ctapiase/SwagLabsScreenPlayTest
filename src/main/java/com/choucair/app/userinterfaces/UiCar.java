package com.choucair.app.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiCar {
    public static final Target CHECKOUT_BUTTON = Target.the("boton de checkout").located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]"));

}
