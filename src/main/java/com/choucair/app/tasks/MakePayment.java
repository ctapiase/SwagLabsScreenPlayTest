package com.choucair.app.tasks;

import com.choucair.app.userinterfaces.UiCheckout;
import com.choucair.moviles.libreria.interactions.choucair.builders.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class MakePayment implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("name").into(UiCheckout.NAME_INPUT),
                Enter.theValue("lastName").into(UiCheckout.LAST_NAME_INPUT),
                Enter.theValue("postalCode").into(UiCheckout.POSTAL_CODE),
                Click.on(UiCheckout.CONTINIU_BUTTON),
                Scroll.on(UiCheckout.BUTTON_FINISH),
                Click.on(UiCheckout.BUTTON_FINISH)
        );
    }

    public static MakePayment pay() {
        return Tasks.instrumented(MakePayment.class);
    }
}
