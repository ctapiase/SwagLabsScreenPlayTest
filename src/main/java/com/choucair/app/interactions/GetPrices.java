package com.choucair.app.interactions;

import com.choucair.app.models.ProductModel;
import com.choucair.app.userinterfaces.UiCar;
import com.choucair.moviles.libreria.interactions.choucair.builders.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.questions.Text;

public class GetPrices implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Double price;
        Double priceTotal = 0.0;
        int cantProduct = actor.recall("CanProduct");
        for (int i = 0; i <= (cantProduct - 2); i++) {
            actor.attemptsTo(
                    Scroll.on(UiCar.PRICE_A_PRODUCT_BY_IND.of(String.valueOf(i+1)))
            );
            price = Double.parseDouble(Text.of(UiCar.PRICE_A_PRODUCT_BY_IND.of(String.valueOf(i+1))).answeredBy(actor).replace("$", ""));
            System.out.println(price + " PRECIOOOO: ");
            priceTotal = priceTotal + price;
        }

        System.out.println("PRECIO TOTAL: " + priceTotal);
        actor.remember("PriceTotalCar",priceTotal);
    }

    public static GetPrices getPrices() {
        return new GetPrices();
    }
}
