package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_table")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name="password")
    private String password;

    public User() {
    }

    public User(String login, String password, Role role, Order order) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.order = order;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login) {
        this.login = login;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;



//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_order",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    Set<Order> orders;


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_book",
//            joinColumns = @JoinColumn(name = "user_is"),
//            inverseJoinColumns = @JoinColumn(name = "book_id"))
//    Set<Book> books;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
