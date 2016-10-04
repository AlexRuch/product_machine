package interaction;

import model.Ordered_products_db;
import model.Products_db;
import model.User_order_db;
import model.Users_db;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ralex on 10/5/16.
 */
@Stateless
public class Interaction_user_order_db {
    public Interaction_user_order_db() {

    }

    @PersistenceContext(unitName = "product_machine")
    EntityManager entityManager;

    public List<User_order_db> all_orders() {
        return entityManager.createQuery("select o from user_order_db o", User_order_db.class).getResultList();
    }

    public List<User_order_db> user_order(int user_id){
        Users_db user = entityManager.createQuery("select u from users_db u where u.id = ?1", Users_db.class).setParameter(1, user_id).getResultList().get(0);
        return entityManager.createQuery("select o from user_order_db o where o.user_db = ?1", User_order_db.class).setParameter(1, user).getResultList();
    }
}
