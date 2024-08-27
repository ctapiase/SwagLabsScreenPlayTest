package com.choucair.app.questions;

import com.choucair.app.models.ProductModel;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class ValidateProductPrice implements Question<Boolean> {
    DataTable productPrices;

    public ValidateProductPrice(DataTable productsPrices) {
        productPrices = productsPrices;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
       Map<String, String> recallProductsPrice = actor.recall("ProductsPrecios");
        int cantProducts = actor.recall("CanProduct");
        boolean Resp = false;

        for (int i = 0; i < cantProducts -1; i++) {
            Resp = ProductModel.setData(productPrices).get(i).getPrice().equals(recallProductsPrice.get(ProductModel.setData(productPrices).get(i).getProducts()));
            System.out.println(Resp + "  RESPUESTA");
            if (!Resp){
                break;
            }
        }
// Clave del producto que deseas mostrar
        String productoBuscado = ProductModel.setData(productPrices).get(0).getProducts();

// Obtener el precio del producto
        String precioApp = recallProductsPrice.get(productoBuscado);

// Mostrar el precio del producto
            System.out.println("El precio de " + productoBuscado + " es: " + precioApp);
            //Precio a comparar
        System.out.println("El precio a comparar es: "+ProductModel.setData(productPrices).get(0).getPrice());

       // String precio = recallProductsPrice.get(productoBuscado);
        System.out.println("Producto: " + ProductModel.setData(productPrices).get(0).getPrice());
        //int size = recallProductsPrice.size();
        System.out.println("size" + recallProductsPrice.size());
       /* for (Map.Entry<String, String> entry : recallProductsPrice.entrySet()) {
            System.out.println("Precio para comparar  "+ (ProductModel.setData(ProductsPrices).get(0).getPrice()) + ",   Precio real  " + entry.getValue());
            //entry.getValue().equals(ProductModel.setData(ProductsPrices).get(0).getPrice());

        }*/

        return Resp;
    }

    public static ValidateProductPrice validate(DataTable productsPrices) {
        return new ValidateProductPrice(productsPrices);
    }
}
