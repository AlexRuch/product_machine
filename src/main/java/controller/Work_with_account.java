package controller;

import interaction.Interaction_order_products_db;
import interaction.Interaction_user_order_db;
import interaction.Interaction_users_db;
import model.Ordered_products_db;
import model.User_order_db;
import model.Users_db;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ralex on 10/5/16.
 */
@ManagedBean
@SessionScoped
public class Work_with_account {
    public Work_with_account() {
    }

    @EJB
    Interaction_users_db interaction_users_db;
    @EJB
    Interaction_user_order_db interaction_user_order_db;

    @EJB
    Interaction_order_products_db interaction_order_products_db;

    private List<User_order_db> user_order_list = new ArrayList<>();
    private List<Ordered_products_db> ordered_products_list = new ArrayList<>();
    private User_order_db order = new User_order_db();

    public String all_user_orders() {
        Users_db users_db = interaction_users_db.current_user();
        user_order_list.clear();
        user_order_list = interaction_user_order_db.user_order(users_db.getId());
        return "account";
    }

    public String order_info(User_order_db order) {
        this.order = order;
        ordered_products_list.clear();
        ordered_products_list = interaction_order_products_db.getOrder(order);
        return "order_info";
    }

    public String addMoney100() {
        interaction_users_db.addMoney100();
        return "account";
    }

    public String addMoney500() {
        interaction_users_db.addMoney500();
        return "account";
    }

    public String addMoney1000() {
        interaction_users_db.addMoney1000();
        return "account";
    }


     /*
    ------------------------------GETTERS AND SETTERS------------------------------
     */

    public List<User_order_db> getUser_order_list() {
        return user_order_list;
    }

    public void setUser_order_list(List<User_order_db> user_order_list) {
        this.user_order_list = user_order_list;
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
