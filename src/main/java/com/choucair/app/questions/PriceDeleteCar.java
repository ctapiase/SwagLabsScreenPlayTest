package com.choucair.app.questions;

import com.choucair.app.tasks.MakePayment;
import com.choucair.app.userinterfaces.UiCheckout;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

public class PriceDeleteCar implements Question <Boolean>{
    Float priceCheckout = 0f;
    Float priceReal = 0f;
    @Override
    public Boolean answeredBy(Actor actor) {
        //System.out.println("SDJSJDAJSJDASJDJASJDSA");
        actor.attemptsTo(
                MakePayment.pay()
        );
        priceCheckout = Float.parseFloat(Text.of(UiCheckout.SUBTOTAL).answeredBy(actor).replace("Subtotal: $", "").trim());
        //System.out.println("Question:  " + actor.recall("PriceReal") + " PriceCheckout: " + priceCheckout);
        priceReal = actor.recall("PriceReal");
        /*String priceCheckout = Text.of(UiCheckout.SUBTOTAL).answeredBy(actor);
        System.out.println(priceCheckout + "  pricecheckout");*/
        //Boolean Resp = priceCheckout.equals(priceReal);
        //System.out.println(priceReal +"=="+priceCheckout );
        return priceReal.intValue() == priceCheckout.intValue();
    }

    public static PriceDeleteCar verifyPriceCheckout() {
        return new PriceDeleteCar();
    }
}
