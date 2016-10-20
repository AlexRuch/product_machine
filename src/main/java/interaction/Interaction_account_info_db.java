package interaction;

        import model.Account_info_db;
        import model.Users_db;

        import javax.ejb.EJB;
        import javax.ejb.Stateless;
        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import java.util.Date;

/**
 * Created by ralex on 10/5/16.
 */
@Stateless
public class Interaction_account_info_db {

    @EJB
    Interaction_users_db interaction_users_db;

    @PersistenceContext(unitName = "product_machine")
    EntityManager entityManager;

    private Date date = new Date();


    public void add_money(float money_sum){
        Users_db user = interaction_users_db.current_user();
        Account_info_db account = new Account_info_db();
        account.setTransaction_date(date);
        account.setTransaction_sum(money_sum);
        entityManager.persist(account);
        user.getAccount().add(account);
        entityManager.persist(user);
    }
}
