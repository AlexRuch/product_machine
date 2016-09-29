package controller;

import model.Ordered_products_db;
import model.Products_db;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ralex on 9/11/16.
 */
@ManagedBean
@SessionScoped
public class Work_with_order {
    public Work_with_order() {
    }

    private List<Products_db> ordered_products = new ArrayList<>();

    public void add_product_in_bag(Products_db product) {
        ordered_products.add(product);
    }

    public void delete_product_in_bag(Products_db product) {
        ordered_products.remove(product);
    }
        /*
    ------------------------------GETTERS AND SETTERS------------------------------
     */

    public List<Products_db> getOrdered_products() {
        return ordered_products;
    }

    public void setOrdered_products(List<Products_db> ordered_products) {
        this.ordered_products = ordered_products;
    }
}
