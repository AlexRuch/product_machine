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

    private List<Products_db> all_products;

    @EJB
    Interaction_products_db interaction_products_db;

    public List<Products_db> list_of_products() {
        return interaction_products_db.all_products();
    }
/*
------------------------------GETTERS AND SETTERS------------------------------
*/

}
