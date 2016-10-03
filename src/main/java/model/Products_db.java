package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ralex on 03.07.16.
 */
@Entity(name = "products_db")
@Table(name = "products_db")
public class Products_db {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String product_name;

    @Column
    private Float product_cost;

    @Column
    private Float product_quantity;

    @OneToMany(mappedBy = "products_db")
    private List<Ordered_products_db> ordered_products_db_list;

    @Column
    private String product_image;



    public int getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Float getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(Float product_cost) {
        this.product_cost = product_cost;
    }

    public Float getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Float product_quantity) {
        this.product_quantity = product_quantity;
    }

    public List<Ordered_products_db> getOrdered_products_db_list() {
        return ordered_products_db_list;
    }

    public void setOrdered_products_db_list(List<Ordered_products_db> ordered_products_db_list) {
        this.ordered_products_db_list = ordered_products_db_list;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
}
