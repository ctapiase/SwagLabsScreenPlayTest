package com.choucair.app.tasks;

import com.choucair.app.userinterfaces.UiCar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DeleteProduct implements Task {
    String product;
    Float PriceCar = 0f;
    Float priceDelete =0f;
    Float PriceExp;
    DecimalFormat df = new DecimalFormat("0.00");
    String PriceReal;


    public DeleteProduct(String product) {
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //System.out.println(Text.of(UiCar.PRICE_A_PRODUCT.of(product)).answeredBy(actor));
        String priceDelete = Text.of(UiCar.PRICE_A_PRODUCT.of(product)).answeredBy(actor);
        priceDelete = priceDelete.replace("$","");
        //System.out.println(priceDelete + "Precio del articulo a borrar");
        //priceDelete = Float.parseFloat();
        actor.attemptsTo(
                Click.on(UiCar.REMOVE_BY_NAME.of(product))
        );
        PriceCar = actor.recall("PriceAdd");
        //System.out.println(PriceCar + " Precio del carrito");
        //System.out.println(priceDelete + "Precio del articulo eliminado");
        PriceExp = PriceCar - Float.parseFloat(priceDelete);
        //PriceReal = df.format(PriceExp);

        /*BigDecimal bigDecimalPriceExp = new BigDecimal(PriceExp);
        bigDecimalPriceExp = bigDecimalPriceExp.setScale(2, RoundingMode.HALF_UP);
        double roundedPriceExp = bigDecimalPriceExp.doubleValue();*/

        //System.out.println("Precio esperado a pagar: " + PriceExp);
        actor.remember("PriceReal", PriceExp);


    }

    public static DeleteProduct delete(String product){
        return Tasks.instrumented(DeleteProduct.class, product);
    }
}
