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
@ManagedBean
@RequestScoped
@Stateless
public class Interaction_products_db {

    public Interaction_products_db() {
    }

    @PersistenceContext(unitName = "product_machine")
    private EntityManager entityManager;

    private List<Products_db> all_products;

    public List<Products_db> all_products() {
        all_products = new ArrayList<>();
        all_products = entityManager.createQuery("select p from products_db p", Products_db.class).getResultList();
        return all_products;
    }

    public List<Products_db> getAll_products() {
        return all_products;
    }

    public void setAll_products(List<Products_db> all_products) {
        this.all_products = all_products;
    }
}
