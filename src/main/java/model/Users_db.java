package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ralex on 30.06.16.
 */
@Entity(name = "users_db")
@Table(name = "users_db")
public class Users_db {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String user_email;

    @Column
    private String user_password;

    @Column
    private String user_role;

    @Column
    private float user_money;

    @OneToOne(mappedBy = "user")
    private Account_info_db account;

    @OneToMany(mappedBy = "user_db")
    private List<User_order_db> order_db_list;


    public int getId() {
        return id;
    }

    public float getUser_money() {
        return user_money;
    }

    public void setUser_money(float user_money) {
        this.user_money = user_money;
    }

    public List<User_order_db> getOrder_db_list() {
        return order_db_list;
    }

    public void setOrder_db_list(List<User_order_db> order_db_list) {
        this.order_db_list = order_db_list;
    }

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

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public Account_info_db getAccount() {
        return account;
    }

    public void setAccount(Account_info_db account) {
        this.account = account;
    }

}