package com.choucair.app.tasks;

import com.choucair.app.interactions.AddSomeProducts;
import com.choucair.app.models.ProductModel;
import com.choucair.app.userinterfaces.UiHome;
import com.choucair.app.userinterfaces.UiPageProduct;
import com.choucair.moviles.libreria.interactions.choucair.builders.Scroll;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ChooseSomeProducts implements Task {

    DataTable productModel;
    DataTable elements;

    public ChooseSomeProducts(DataTable productModel) {
        this.productModel = productModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("CANTIDADD" + productModel.height() + ProductModel.setData(productModel).get(0).getProducts());
        int cantProduct = productModel.height();
        System.out.println(cantProduct);
        for (int i = 0; i <= (cantProduct - 2); i++) {
            System.out.println("PRODUCTO"+ProductModel.setData(productModel).get(i).getProducts());
            actor.attemptsTo(
                    Scroll.on(UiHome.PRODUCT.of(ProductModel.setData(productModel).get(i).getProducts())),
                    Click.on(UiHome.PRODUCT.of(ProductModel.setData(productModel).get(i).getProducts())),
                    Scroll.on(UiPageProduct.ADD_TO_CART),
                    Click.on(UiPageProduct.ADD_TO_CART),
                    Click.on(UiPageProduct.BACK_TO_PRODUCTS)
            );
        }
        actor.attemptsTo(
                Click.on(UiHome.BUTTON_CAR)
        );
        //AddSomeProducts.add(productModel);
    }

    public static ChooseSomeProducts choose( DataTable productModel){
        return Tasks.instrumented(ChooseSomeProducts.class, productModel);
    }
}
