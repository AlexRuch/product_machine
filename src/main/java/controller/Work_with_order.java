package controller;

import interaction.Interaction_order_products_db;
import interaction.Interaction_products_db;
import interaction.Interaction_users_db;
import model.Ordered_products_db;
import model.Products_db;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

/**
 * Created by ralex on 9/11/16.
 */
@ManagedBean
@SessionScoped
public class Work_with_order {
    public Work_with_order() {
    }

    @EJB
    Interaction_order_products_db interaction_order_products_db;
    private List<Products_db> ordered_products = new ArrayList<>();
    private Map<Integer, Integer> map_products = new HashMap<>();
    private String order_result;

    public void add_product_in_bag(Products_db product) {
        ordered_products.add(product);
    }

    public void delete_product_in_bag(Products_db product) {
        ordered_products.remove(product);
    }

    public String confirm_order_in_bag(List<Products_db> products_in_bag) {
        float order_sum = 0;
        map_products.clear();

        for (Products_db product : products_in_bag) {
            if (map_products.containsKey(product.getId())) {
                map_products.put(product.getId(), map_products.get(product.getId()) + 1);
            } else {
                map_products.put(product.getId(), 1);
            }
            order_sum = order_sum + product.getProduct_cost();
        }

        if (!map_products.isEmpty()) {
            if (interaction_order_products_db.check_order(map_products, order_sum)) {
                interaction_order_products_db.confirm_order(map_products, order_sum);
                ordered_products.clear();
                products_in_bag.clear();
                map_products.clear();
                order_result = "Success!";
                return "order_result.xhtml";
            } else {
                order_result = "Filed. You do not have enough money or we do not have enough products :)";
                return "order_result.xhtml";
            }
        }
        else {
            return "bag.xhtml";
        }

    }

        /*
    ------------------------------GETTERS AND SETTERS------------------------------
     */

    public String getOrder_result() {
        return order_result;
    }

    public void setOrder_result(String order_result) {
        this.order_result = order_result;
    }

    public List<Products_db> getOrdered_products() {
        return ordered_products;
    }

    public void setOrdered_products(List<Products_db> ordered_products) {
        this.ordered_products = ordered_products;
    }
}
