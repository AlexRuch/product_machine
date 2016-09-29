package model;

import javax.persistence.*;

/**
 * Created by ralex on 03.07.16.
 */
@Entity(name = "ordered_products_db")
@Table(name = "ordered_products_db")
public class Ordered_products_db {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products_db products_db;

    @Column
    private int product_quantity;

    public int getId() {
        return id;
    }

    public Products_db getProducts_db() {
        return products_db;
    }

    public void setProducts_db(Products_db products_db) {
        this.products_db = products_db;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }


}
