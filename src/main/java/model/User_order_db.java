package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ralex on 03.07.16.
 */
@Entity(name = "user_order_db")
@Table(name = "user_order_db")
public class User_order_db {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users_db user_db;

    @OneToMany(mappedBy = "order_db")
    private List<Ordered_products_db> ordered_products_db;

    @Column
    private Date order_date;

    @Column
    private float order_sum;

    @OneToOne(mappedBy = "order")
    private Account_info_db account_info_db;

    public int getId() {
        return id;
    }

    public List<Ordered_products_db> getOrdered_products_db() {
        return ordered_products_db;
    }

    public void setOrdered_products_db(List<Ordered_products_db> ordered_products_db) {
        this.ordered_products_db = ordered_products_db;
    }

    public Account_info_db getAccount_info_db() {
        return account_info_db;
    }

    public void setAccount_info_db(Account_info_db account_info_db) {
        this.account_info_db = account_info_db;
    }

    public Users_db getUser_db() {
        return user_db;
    }

    public void setUser_db(Users_db user_db) {
        this.user_db = user_db;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public float getOrder_sum() {
        return order_sum;
    }

    public void setOrder_sum(float order_sum) {
        this.order_sum = order_sum;
    }
}
