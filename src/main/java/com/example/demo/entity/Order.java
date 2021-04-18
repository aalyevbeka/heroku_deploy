package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "adres")
    private String adres;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "user_email")
    private String email;

    @Column(name = "order_data")
    private String orderData;



//    @ManyToMany(fetch = FetchType.LAZY,
//                mappedBy = "orders")
//    Set<User> users;



    public Order() {
    }

    public Order( String adres, String phone_number, String email, String orderData) {
        this.adres = adres;
        this.phone_number = phone_number;
        this.email = email;
        this.orderData = orderData;
        //this.user = user;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }
}
