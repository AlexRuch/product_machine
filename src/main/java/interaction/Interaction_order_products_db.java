package interaction;

import model.Ordered_products_db;
import model.Products_db;

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

    @PersistenceContext(unitName = "product_machine")
    private EntityManager entityManager;

    public void confirm_order(Map<Integer, Integer> ordered_products_db_list) {
        Ordered_products_db ordered_product = new Ordered_products_db();
        for (Map.Entry entry : ordered_products_db_list.entrySet()) {
            Products_db products_db = entityManager.find(Products_db.class, entry.getKey());
            ordered_product = new Ordered_products_db();
            ordered_product.setProducts_db(products_db);
            ordered_product.setProduct_quantity((Integer) entry.getValue());
            entityManager.persist(ordered_product);
        }
    }

    public int size() {
        List<Products_db> all_products = new ArrayList<>();
        all_products = entityManager.createQuery("select p from products_db p", Products_db.class).getResultList();
        return all_products.size();
    }
}
