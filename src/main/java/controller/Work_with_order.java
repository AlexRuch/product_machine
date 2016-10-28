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
    private List<Products_db> products_in_bag = new ArrayList<>();
    private Map<Integer, Integer> map_products = new HashMap<>();
    private String order_result;
    private float order_sum = 0;
    private float order_quantity = 0;
    private int status;

    public void add_product_in_bag(Products_db product) {

        if (products_in_bag.size() == 0) {
            product.setProduct_quantity(1);
            products_in_bag.add(product);
        } else {
            for (Products_db products_db : products_in_bag) {
                status = 0;
                if (products_db.getId() == product.getId()) {
                    status = 1;
                    int index = products_in_bag.indexOf(products_db);
                    product.setProduct_quantity(products_db.getProduct_quantity() + 1);
                    products_in_bag.set(index, product);
                }
            }
            if (status == 0) {
                product.setProduct_quantity(1);
                products_in_bag.add(product);
            }
        }

        order_sum = order_sum + product.getProduct_cost();
    }

    public void delete_product_in_bag(Products_db product) {
        if (product.getProduct_quantity() > 1) {
            int index = products_in_bag.indexOf(product);
            product.setProduct_quantity(product.getProduct_quantity() - 1);
            products_in_bag.set(index, product);
        } else {
            products_in_bag.remove(product);
        }
        order_sum = order_sum - product.getProduct_cost();
//        ordered_products.remove(product);
    }

    public String confirm_order_in_bag(List<Products_db> products_list) {
        map_products.clear();

        for (Products_db product : products_list) {
            map_products.put(product.getId(), product.getProduct_quantity());
        }

        if (!map_products.isEmpty()) {
            if (interaction_order_products_db.check_order(map_products, order_sum)) {
                interaction_order_products_db.confirm_order(map_products, order_sum);
                products_in_bag.clear();
                map_products.clear();
                this.products_in_bag.clear();
                this.order_sum = 0;
                order_result = "Success!";
                return "order_result.xhtml";
            } else {
                order_result = "Filed. You do not have enough money or we do not have enough products :) <br/> Go to <a href=\"account.xhtml\">ACCOUNT</a> and add money.";
                return "order_result.xhtml";
            }
        } else {
            return "bag.xhtml";
        }

    }

        /*
    ------------------------------GETTERS AND SETTERS------------------------------
     */

    public List<Products_db> getProducts_in_bag() {
        return products_in_bag;
    }

    public void setProducts_in_bag(List<Products_db> products_in_bag) {
        this.products_in_bag = products_in_bag;
    }

    public float getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(float order_quantity) {
        this.order_quantity = order_quantity;
    }

    public float getOrder_sum() {
        return order_sum;
    }

    public void setOrder_sum(float order_sum) {
        this.order_sum = order_sum;
    }

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
