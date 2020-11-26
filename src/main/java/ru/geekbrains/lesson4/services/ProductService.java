package ru.geekbrains.lesson4.services;

import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

public interface ProductService {

    Product get(Long id);
    List<Product> getAll();
    void save(Product product);
    void remove(Product product);
    Product findByName(String name);
    Double findMaxPrice();
    List<Product> findProductByPriceEquals(Double price);

}
