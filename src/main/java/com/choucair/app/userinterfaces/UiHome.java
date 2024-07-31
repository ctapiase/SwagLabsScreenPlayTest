package com.choucair.app.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiHome {
    public static final Target PRODUCT = Target.the("Campo de texto username").locatedBy(("//android.widget.TextView[@text='{0}']"));
    public static final Target BUTTON_CAR = Target.the("Campo de texto username").located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Carrito\"]/android.view.ViewGroup/android.widget.ImageView"));

}
