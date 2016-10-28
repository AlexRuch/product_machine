package interaction;

import model.Products_db;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ralex on 9/10/16.
 */
@Stateless
public class Interaction_products_db {

    public Interaction_products_db() {

    }

    @PersistenceContext(unitName = "product_machine")
    private EntityManager entityManager;

    public List<Products_db> all_products() {
        return entityManager.createQuery("select p from products_db p", Products_db.class).getResultList();
    }

    public void add_product(Products_db product) {
        Products_db products_db;
        products_db = entityManager.createQuery("select p from products_db p where p.id = ?1", Products_db.class).setParameter(1, product.getId()).getResultList().get(0);
        products_db.setProduct_quantity(products_db.getProduct_quantity() + 5);
        entityManager.persist(products_db);
    }
}
