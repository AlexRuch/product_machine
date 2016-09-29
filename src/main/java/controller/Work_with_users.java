package controller;



import interaction.Interaction_users_db;
import model.Users_db;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by ralex on 30.06.16.
 */
@ManagedBean
@SessionScoped
public class Work_with_users {
    public Work_with_users(){}

    private String user_email;
    private String user_password;
    private String registration_result_text;

    @EJB
    Interaction_users_db interaction_users_db;
    Users_db users_db;
    public String registration(){
        if(interaction_users_db.check_user(user_email) == null){
        users_db = new Users_db();
        users_db.setUser_email(user_email);
        users_db.setUser_password(user_password);
        users_db.setUser_account(0.0);
        users_db.setUser_role("user");
        interaction_users_db.createUser(users_db);
            registration_result_text = "Success! \n Now sign in and <a href = \"user/index.xhtml\">buy</a> something!";
        }
        else {
            registration_result_text = "Registration field. This e-mail already used! \n <a href=\"registration.xhtml>Try again!</a>";
        }
        return "registration_result";
    }


    /*
    ------------------------------GETTERS AND SETTERS------------------------------
     */
    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
