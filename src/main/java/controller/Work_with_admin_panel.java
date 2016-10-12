package controller;

import interaction.Interaction_order_products_db;
import interaction.Interaction_user_order_db;
import model.Ordered_products_db;
import model.User_order_db;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ralex on 9/10/16.
 */
@ManagedBean
@SessionScoped
public class Work_with_admin_panel {

    public Work_with_admin_panel() {

    }

    @EJB
    Interaction_user_order_db interaction_user_order_db;
    @EJB
    Interaction_order_products_db interaction_order_products_db;

    private List<Ordered_products_db> ordered_products_list = new ArrayList<>();
    private User_order_db order = new User_order_db();

    public List<User_order_db> all_orders() {
        return interaction_user_order_db.all_orders();
    }

    public String order_info(User_order_db order) {
        this.order = order;
        ordered_products_list.clear();
        ordered_products_list = interaction_order_products_db.getOrder(order);
        return "order_info";
    }

    public List<Ordered_products_db> getOrdered_products_list() {
        return ordered_products_list;
    }

    public void setOrdered_products_list(List<Ordered_products_db> ordered_products_list) {
        this.ordered_products_list = ordered_products_list;
    }

    public User_order_db getOrder() {
        return order;
    }

    public void setOrder(User_order_db order) {
        this.order = order;
    }
}
