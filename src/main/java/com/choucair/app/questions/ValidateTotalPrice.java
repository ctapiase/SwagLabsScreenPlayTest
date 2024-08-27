package com.choucair.app.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateTotalPrice implements Question <Boolean> {
    Float Price;
    Float PriceTotal;

    public ValidateTotalPrice(Float price) {
        Price = price;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println("QUESTIONNN");
        PriceTotal = actor.recall("PriceAdd");
        System.out.println("Price: " + Price);
        System.out.println("PriceTotal: " + PriceTotal); ;

        return (PriceTotal).equals(Price);
    }

    public static ValidateTotalPrice validate(Float price) {
        return new ValidateTotalPrice(price);
    }
}
