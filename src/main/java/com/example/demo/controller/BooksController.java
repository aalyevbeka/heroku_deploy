package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {
    @Autowired
    private BooksService service;

    //method is create book
    @PostMapping("/create")
    public ResponseEntity<?> createBooks(@RequestBody Book book){
        service.createBooks(book);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    //method is search book by author
    @GetMapping("/author/{author}")
    public Book searchBooksByAuthor(@PathVariable String author){
        return  service.findByAuthor(author);
    }

    //method is delete book by name
    @DeleteMapping("/delete/{deleteByName}")
    public ResponseEntity<?> deleteBookByName(@PathVariable String deleteByName){
        service.deleteBooksByName(deleteByName);
        return new ResponseEntity<>(deleteByName + "is delete", HttpStatus.OK);
    }

    //method is get all
    @GetMapping("/getall")
    public List<Book> getAll(){
    return service.getAll();
    }


    //method is get book by name
    @GetMapping("/name/{name}")
    public Book getName(@PathVariable String name){
        return service.findByName(name);
    }


    //method is sort by price low to high
    @GetMapping ("/sort")
    public List<Book> sortByPrice() {
        return service.sortByPrice();
    }

    //method is edit book by id
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editBook(@PathVariable long id, Book book){
        Book newBook = service.edit(book,id);
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }
}
