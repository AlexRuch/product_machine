package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ralex on 03.07.16.
 */
@Entity(name = "user_order_db")
@Table(name = "user_order_db")
public class User_order_db {
    @Id
    @GeneratedValue
    private int id;

}
