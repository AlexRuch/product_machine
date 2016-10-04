package interaction;

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
    public  Interaction_account_info_db(){

    }

    @EJB
    Interaction_users_db interaction_users_db;

    @PersistenceContext(unitName = "product_machine")
    EntityManager entityManager;

    private Date date = new Date();

    public void add_money(float money_sum){
        Users_db user = interaction_users_db.current_user();
        user.getAccount().setTransaction_sum(money_sum);
        user.getAccount().setTransaction_date(date);
    }
}
