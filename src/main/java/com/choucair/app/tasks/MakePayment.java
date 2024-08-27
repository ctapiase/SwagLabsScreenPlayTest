package com.choucair.app.tasks;

import com.choucair.app.interactions.AddSomeProducts;
import com.choucair.app.interactions.GetSubTotal;
import com.choucair.app.models.ProductModel;
import com.choucair.app.userinterfaces.UiCar;
import com.choucair.app.userinterfaces.UiCheckout;
import com.choucair.moviles.libreria.interactions.choucair.builders.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

public class MakePayment implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        Text.of(UiCheckout.SUB_TOTAL).answeredBy(actor).replace("$", "");
        actor.attemptsTo(
                Scroll.on(UiCar.CHECKOUT_BUTTON),
                Click.on(UiCar.CHECKOUT_BUTTON),
                Enter.theValue("name").into(UiCheckout.NAME_INPUT),
                Enter.theValue("lastName").into(UiCheckout.LAST_NAME_INPUT),
                Enter.theValue("postalCode").into(UiCheckout.POSTAL_CODE),
                Click.on(UiCheckout.CONTINIU_BUTTON)
                //GetSubTotal.checkSubtotal()
               // actor.remember("NoDeleteSubTotal");

        );
    }

    public static MakePayment pay() {
        return Tasks.instrumented(MakePayment.class);
    }
}
