package com.choucair.app.questions;

import com.choucair.app.userinterfaces.UiCheckout;
import com.choucair.moviles.libreria.interactions.choucair.builders.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ConfirmMsg implements Question <Boolean>{

    String msg;

    public ConfirmMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Scroll.on(UiCheckout.BUTTON_FINISH),
                Click.on(UiCheckout.BUTTON_FINISH),
                WaitUntil.the(UiCheckout.MESSAGE_COMPLETED, WebElementStateMatchers.isPresent()).forNoMoreThan(3).seconds()
        );
        msg = Text.of(UiCheckout.MESSAGE_COMPLETED).answeredBy(actor);
        return msg.contains(Text.of(UiCheckout.MESSAGE_COMPLETED).answeredBy(actor));
    }

    public static ConfirmMsg msgPayment(String msg) {
        return new ConfirmMsg(msg);
    }
}


