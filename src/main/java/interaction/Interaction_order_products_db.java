package interaction;

import model.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by ralex on 9/10/16.
 */
@Stateless
public class Interaction_order_products_db {

    public Interaction_order_products_db() {

    }

    @EJB
    Interaction_users_db interaction_users_db;

    @PersistenceContext(unitName = "product_machine")
    private EntityManager entityManager;

    private List<Ordered_products_db> ordered_products_db_list = new ArrayList<>();

    private Date date;

    public void confirm_order(Map<Integer, Integer> ordered_products_db_map, float order_sum) {
        date = new Date();
        Account_info_db account_info_db = new Account_info_db();
        Ordered_products_db ordered_product;
        User_order_db user_order_db = new User_order_db();
        Users_db user_db = interaction_users_db.current_user();
        user_order_db.setUser_db(user_db);
        entityManager.persist(user_order_db);
        for (Map.Entry entry : ordered_products_db_map.entrySet()) {
            Products_db products_db = entityManager.find(Products_db.class, entry.getKey());
            ordered_product = new Ordered_products_db();
            ordered_product.setProducts_db(products_db);
            ordered_product.setProduct_quantity((Integer) entry.getValue());
            ordered_product.setOrder_db(user_order_db);
            products_db.setProduct_quantity(products_db.getProduct_quantity() - (Integer) entry.getValue());
            ordered_product.setTotal_cost(products_db.getProduct_cost() * (Integer) entry.getValue());
            entityManager.persist(products_db);
            entityManager.persist(ordered_product);
            ordered_products_db_list.add(ordered_product);
        }

        user_order_db.setOrdered_products_db(ordered_products_db_list);
        user_order_db.setOrder_date(date);
        user_order_db.setOrder_sum(order_sum);
        user_order_db.setAccount_info_db(account_info_db);
        entityManager.persist(user_order_db);
        user_db.getOrder_db_list().add(user_order_db);
        user_db.setUser_money(user_db.getUser_money() - order_sum);
        entityManager.persist(user_db);

        account_info_db.setTransaction_date(date);
        account_info_db.setUser(user_db);
        account_info_db.setTransaction_sum(order_sum);
        account_info_db.setOrder(user_order_db);
        entityManager.persist(account_info_db);
        user_db.getAccount().add(account_info_db);
        entityManager.persist(user_db);

        ordered_products_db_list.clear();

    }

    public boolean check_order(Map<Integer, Integer> ordered_products_db_map, float order_sum){
        boolean money_status;
        boolean product_status = false;

        if(order_sum < interaction_users_db.current_user().getUser_money()){
            money_status = true;
        }
        else {
            money_status = false;
        }
        for (Map.Entry entry : ordered_products_db_map.entrySet()){
            Products_db products_db = entityManager.find(Products_db.class, entry.getKey());
            if ((Integer) entry.getValue() < products_db.getProduct_quantity()){
                product_status = true;
            }
            else {
                product_status = false;
            }

            product_status = product_status && product_status;
        }

        return product_status && money_status;
    }

    public List<Ordered_products_db> getOrder(User_order_db order){
        return entityManager.createQuery("select o from ordered_products_db o where o.order_db = ?1", Ordered_products_db.class).setParameter(1, order).getResultList();
    }
}
