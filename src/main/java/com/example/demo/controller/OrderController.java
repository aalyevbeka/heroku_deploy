package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    //method is save order
    @PostMapping("/save")
    public ResponseEntity seveOder(@RequestBody Order order) {
         service.saveOder(order);
         return new ResponseEntity(order,HttpStatus.OK);
    }


    //method is get all orders
    @GetMapping("/getorder")
    public List<Order> getAll(){
        return service.getAll();
    }


    //method is get order by id
    @GetMapping("/get/{id}")
    public Order getByName(@PathVariable int id){
        return service.getById(id);
    }

    //method is delete by id
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
    service.delete(id);
    }


    //method is edit by id
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editOrder(@PathVariable int id, Order order){
        Order order1 = service.editOrder(id,order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
