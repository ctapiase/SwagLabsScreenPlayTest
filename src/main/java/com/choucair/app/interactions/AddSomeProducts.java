package com.choucair.app.interactions;

import com.choucair.app.models.ProductModel;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class AddSomeProducts implements Interaction {
    DataTable products;

    public AddSomeProducts(DataTable products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("INTERACTIONNNNN");
        int cantProduct = products.height();
        for (int i = 0; i < cantProduct; i++) {
            System.out.println("PRODUCTO"+ProductModel.setData(products).get(i).getProducts());
        }
    }

    public static AddSomeProducts add(DataTable products){
        return Tasks.instrumented(AddSomeProducts.class, products);
    }
}
