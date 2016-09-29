package model;

import javax.persistence.*;

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
    private double user_account;

    public int getId() {
        return id;
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

    public double getUser_account() {
        return user_account;
    }

    public void setUser_account(double user_account) {
        this.user_account = user_account;
    }
}