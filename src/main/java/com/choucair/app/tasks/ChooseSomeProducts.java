package com.choucair.app.tasks;

import com.choucair.app.interactions.AddSomeProducts;
import com.choucair.app.models.ProductModel;
import com.choucair.app.userinterfaces.UiCar;
import com.choucair.app.userinterfaces.UiHome;
import com.choucair.app.userinterfaces.UiPageProduct;
import com.choucair.moviles.libreria.interactions.choucair.Swipe;
import com.choucair.moviles.libreria.interactions.choucair.builders.Scroll;
import com.choucair.moviles.libreria.interactions.choucair.scroll.ScrollLateral;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ChooseSomeProducts implements Task {

    DataTable productModel;
    DataTable elements;

    public ChooseSomeProducts(DataTable productModel) {
        this.productModel = productModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Float priceAdd = 0f;
        Map<String, String> productosPrecios = new HashMap<>();

        Float priceTotal = 0f;
        DecimalFormat df = new DecimalFormat("0.00");
        String PriceReal;

        System.out.println("CANTIDADD" + productModel.height() +  "PRIMER PRODUCTO" +ProductModel.setData(productModel).get(0).getProducts());
        int cantProduct = productModel.height();
        actor.remember("CanProduct", cantProduct);
        //System.out.println(cantProduct);
        for (int i = 0; i <= (cantProduct - 2); i++) {
            //System.out.println("PRODUCTO"+ProductModel.setData(productModel).get(i).getProducts());
            actor.attemptsTo(
                    Scroll.on(UiHome.PRODUCT.of(ProductModel.setData(productModel).get(i).getProducts())),
                    Click.on(UiHome.PRODUCT.of(ProductModel.setData(productModel).get(i).getProducts())),
                    Scroll.on(UiPageProduct.ADD_TO_CART)
            );
            productosPrecios.put(ProductModel.setData(productModel).get(i).getProducts(), Text.of(UiPageProduct.PRICE_PRODUCT).answeredBy(actor).replace("$", ""));
            priceAdd = priceAdd + Float.parseFloat(Text.of(UiPageProduct.PRICE_PRODUCT).answeredBy(actor).replace("$", ""));
            System.out.println("Precio agregado" + priceAdd);
            actor.attemptsTo(
                    Click.on(UiPageProduct.ADD_TO_CART),
                    Click.on(UiPageProduct.BACK_TO_PRODUCTS)
            );
        }

        // Recuperar el mapa recordado por el actor


// Mostrar el contenido del mapa
       /* for (Map.Entry<String, String> entry : productosPrecios.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + ", Precio: $" + entry.getValue());
        }*/
        actor.remember("ProductsPrecios", productosPrecios);
        actor.remember("PriceAdd", priceAdd);
        priceTotal = actor.recall("PriceAdd");
        PriceReal = df.format(priceAdd);
        System.out.println(PriceReal+" PRICETOTAL " + priceAdd);
        actor.attemptsTo(
                Click.on(UiHome.BUTTON_CAR)
        );
       /*or (int i = 0; i <= (cantProduct - 2); i++) {
            actor.attemptsTo(
                    Scroll.on(UiCar.PRICE_A_PRODUCT_BY_IND.of(String.valueOf(i+1)))
            );
            price = Double.parseDouble(Text.of(UiCar.PRICE_A_PRODUCT_BY_IND.of(String.valueOf(i+1))).answeredBy(actor).replace("$", ""));
            System.out.println(price + "   PRECIOOOO");
            priceTotal = priceTotal + price;
        }

        System.out.println("PRECIO TOTAL:  " + priceTotal);
        actor.remember("PriceTotalCar",priceTotal);*/
  /*      actor.attemptsTo(
                MakePayment.pay()
        );*/
        //AddSomeProducts.add(productModel);
    }

    public static ChooseSomeProducts choose( DataTable productModel){
        return Tasks.instrumented(ChooseSomeProducts.class, productModel);
    }
}
