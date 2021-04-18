package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order saveOder(Order order){
        Order newOrder = new Order();
        newOrder.setAdres(order.getAdres());
        newOrder.setPhone_number(order.getPhone_number());
        newOrder.setEmail(order.getEmail());
        newOrder.setOrderData(order.getOrderData());
        return  orderRepository.save(newOrder);
    }

    public void delete(int id){
        orderRepository.deleteById(id);
    }

    public Order editOrder(int id,Order order){
        if (orderRepository.findById(id).isPresent()){
            Order order1 = orderRepository.getOne(id);
            order1.setAdres(order.getAdres());
            order1.setEmail(order.getEmail());
            order1.setPhone_number(order.getPhone_number());
            order1.setOrderData(order.getOrderData());
            return orderRepository.save(order1);
        }else {
            return null;
        }
    }


    public Order getById(int id) {
        return orderRepository.getOne(id);
    }
}
