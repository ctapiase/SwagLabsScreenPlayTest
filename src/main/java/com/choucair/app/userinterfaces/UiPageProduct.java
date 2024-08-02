package com.choucair.app.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiPageProduct {
    public static final Target ADD_TO_CART = Target.the("boton para añadir al carrito").located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-AÑADIR A CARRITO\"]"));
    public static final Target BACK_TO_PRODUCTS = Target.the("boton para regresar a productos").located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-REGRESO A PRODUCTOS\"]"));

}
