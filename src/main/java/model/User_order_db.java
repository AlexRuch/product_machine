package model;

import javax.persistence.*;
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

    public int getId() {
        return id;
    }

    public List<Ordered_products_db> getOrdered_products_db() {
        return ordered_products_db;
    }

    public void setOrdered_products_db(List<Ordered_products_db> ordered_products_db) {
        this.ordered_products_db = ordered_products_db;
    }

    public Users_db getUser_db() {
        return user_db;
    }

    public void setUser_db(Users_db user_db) {
        this.user_db = user_db;
    }
}
