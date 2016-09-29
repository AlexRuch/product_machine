package interaction;


import model.Users_db;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by ralex on 30.06.16.
 */
@Stateless
public class Interaction_users_db {
    @PersistenceContext(unitName = "product_machine")
    private EntityManager entityManager;

    public void createUser(Users_db users_db){
        entityManager.persist(users_db);
    }

    public Users_db check_user(String user_email){
        Users_db user;
        user = entityManager.createQuery("select u from users_db u where u.user_email = ?1", Users_db.class).setParameter(1, user_email).getResultList().get(0);
        return user;
    }
}
