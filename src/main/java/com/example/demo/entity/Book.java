package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "table_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

//    @ManyToMany(mappedBy = "books")
//    Set<User> users;

    public Book(String name, String author, String description, String genre, int price) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.price = price;
    }

    public Book(long id,String name, String author, String description, String genre, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.price = price;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
