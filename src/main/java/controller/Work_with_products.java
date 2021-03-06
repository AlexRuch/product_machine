package controller;

import interaction.Interaction_products_db;
import model.Products_db;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ralex on 9/10/16.
 */
@ManagedBean
@RequestScoped
public class Work_with_products {
    public Work_with_products() {
    }

    @EJB
    Interaction_products_db interaction_products_db;

    public List<Products_db> list_of_products() {
        return interaction_products_db.all_products();
    }

    public String add_product(Products_db product) {
        interaction_products_db.add_product(product);
        return "index";
    }
/*
------------------------------GETTERS AND SETTERS------------------------------
*/

}
