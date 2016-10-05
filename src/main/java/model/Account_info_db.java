package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ralex on 03.07.16.
 */
@Entity(name = "account_info_db")
@Table(name = "account_info_db")
public class Account_info_db {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users_db user;

    @OneToOne
    @JoinColumn(name = "order_id")
    private User_order_db order;

    @Column
    private float transaction_sum;

    @Column
    private Date transaction_date;

    public int getId() {
        return id;
    }

    public Users_db getUser() {
        return user;
    }

    public void setUser(Users_db user) {
        this.user = user;
    }

    public User_order_db getOrder() {
        return order;
    }

    public void setOrder(User_order_db order) {
        this.order = order;
    }

    public float getTransaction_sum() {
        return transaction_sum;
    }

    public void setTransaction_sum(float transaction_sum) {
        this.transaction_sum = transaction_sum;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

}
