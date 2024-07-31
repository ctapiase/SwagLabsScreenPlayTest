package com.choucair.app.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiCheckout {
    public static final Target NAME_INPUT = Target.the("Campo de texto nombre").located(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Nombre\"]"));
    public static final Target LAST_NAME_INPUT = Target.the("Campo de texto apellido").located(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Apellido\"]"));
    public static final Target POSTAL_CODE = Target.the("Campo de texto codigo postal").located(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Código postal\"]"));
    public static final Target CONTINIU_BUTTON = Target.the("boton continuar").located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUAR\"]"));
    public static final Target BUTTON_FINISH = Target.the("boton terminar").located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-TERMINAR\"]"));
    public static final Target MESSAGE_COMPLETED = Target.the("mensage orden completada").located(AppiumBy.xpath("//android.widget.TextView[@text=\"GRACIAS POR SU ORDEN\"]"));
    public static final Target BUTTON_RETURN_TO_MENU = Target.the("boton regresar al menu").located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-REGRESO A MENU\"]"));

}
