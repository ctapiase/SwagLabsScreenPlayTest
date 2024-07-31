package com.choucair.app.tasks;

import com.choucair.app.userinterfaces.UiCar;
import com.choucair.app.userinterfaces.UiHome;
import com.choucair.app.userinterfaces.UiPageProduct;
import com.choucair.moviles.libreria.interactions.choucair.builders.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ChooseProduct implements Task {
    String productName;

    public ChooseProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.on(UiHome.PRODUCT.of(productName)),
                Click.on(UiHome.PRODUCT.of(productName)),
                Click.on(UiPageProduct.ADD_TO_CART),
                Click.on(UiHome.BUTTON_CAR),
                Click.on(UiCar.CHECKOUT_BUTTON)
        );
    }

    public static ChooseProduct choose(String productName) {
        return Tasks.instrumented(ChooseProduct.class, productName);
    }
}
