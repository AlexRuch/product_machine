package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ralex on 03.07.16.
 */
@Entity(name = "account_info_db")
@Table(name = "account_info_db")
public class Account_info_db {
    @Id
    @GeneratedValue
    private int id;
}
