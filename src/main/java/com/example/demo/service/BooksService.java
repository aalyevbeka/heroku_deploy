package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repository.BooksRepository;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService  {

    @Autowired
    private BooksRepository repository;


    public Book createBooks(Book book) {
        Book newBook = new Book();
        newBook.setName(book.getName());
        newBook.setAuthor(book.getAuthor());
        newBook.setDescription(book.getDescription());
        newBook.setGenre(book.getGenre());
        return repository.save(newBook);
    }

    public Book findByName(String name){
        return repository.findByName(name);
    }


    public Book findByAuthor(String author) {
        return  repository.findByAuthor(author);
}

    public void deleteBooksByName(String name) {
     Book book = repository.findByName(name);
        repository.delete(book);
    }

    public List<Book> getAll(){
        return repository.findAll();
    }

    public List<Book> sortByPrice(){
        return repository.findByOrderByPriceAsc();
    }

    public Book edit(Book book,long id){
        if (repository.findById(id).isPresent()){
            Book editBook = repository.getOne(id);
            editBook.setName(book.getName());
            editBook.setAuthor(book.getAuthor());
            editBook.setDescription(book.getDescription());
            editBook.setGenre(book.getGenre());
            editBook.setPrice(book.getPrice());
            return repository.save(editBook);
        } else {
            return null;
        }
    }
}
