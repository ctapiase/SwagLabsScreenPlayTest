package com.choucair.app.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiLogIn {
    public static final Target USERNAME_INPUT = Target.the("Campo de texto username").located(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Usuario\"]"));
    public static final Target PASSWORD_INPUT = Target.the("Campo de texto username").located(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Contraseña\"]"));
    public static final Target LOGIN_BUTTON = Target.the("Campo de texto username").located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));

}
