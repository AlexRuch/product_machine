package interaction;

import model.Ordered_products_db;
import model.Products_db;
import model.User_order_db;
import model.Users_db;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
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

    List<Ordered_products_db> ordered_products_db_list = new ArrayList<>();

    public void confirm_order(Map<Integer, Integer> ordered_products_db_map) {
        Ordered_products_db ordered_product = new Ordered_products_db();
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
            entityManager.persist(ordered_product);
            ordered_products_db_list.add(ordered_product);
        }
        user_order_db.setOrdered_products_db(ordered_products_db_list);
        entityManager.persist(user_order_db);
        user_db.getOrder_db_list().add(user_order_db);
        entityManager.persist(user_db);

        ordered_products_db_list.clear();
    }
}
