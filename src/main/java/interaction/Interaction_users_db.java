package interaction;


import model.Users_db;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ralex on 30.06.16.
 */
@Stateless
public class Interaction_users_db {
    @PersistenceContext(unitName = "product_machine")
    private EntityManager entityManager;

    public void createUser(Users_db users_db) {
        entityManager.persist(users_db);
    }

    public List<Users_db> check_user(String user_email) {
        return entityManager.createQuery("select u from users_db u where u.user_email = ?1", Users_db.class).setParameter(1, user_email).getResultList();
    }

    public Users_db current_user() {
        return entityManager.createQuery("select u from users_db u where u.user_email = ?1", Users_db.class).setParameter(1, FacesContext.getCurrentInstance().getExternalContext().getRemoteUser()).getResultList().get(0);
    }
}
