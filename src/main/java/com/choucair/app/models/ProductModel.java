package com.choucair.app.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductModel {
    String products;

    public static List<ProductModel> setData(DataTable dataTable) {
        List<ProductModel> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, ProductModel.class));
        }
        return dates;
    }

    public String getProducts() {
        return products;
    }

    public static int getNumberOfElements(DataTable productList) {
        return productList.height();
    }

    public static int getNumberOfElements(ProductModel productModel) {
        return productModel.getProducts() != null ? 1 : 0;
    }
}
