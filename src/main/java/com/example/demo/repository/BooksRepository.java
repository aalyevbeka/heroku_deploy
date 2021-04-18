package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book,Long> {
Book findByAuthor(String name);
Book findByName(String name);
List<Book> findByOrderByPriceAsc();
//    @Query("select  name from  table_book order by price")
//    List<Book> orderPrice();
}
















