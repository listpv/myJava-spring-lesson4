package ru.geekbrains.lesson4.services;

import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

public interface CatalogService {

    Catalog get(Long id);
    List<Catalog> getAll();
    void save(Catalog catalog);
    void remove(Catalog catalog);

//    Long findMinPrise(Catalog catalog);
//    Long findMaxPrise(Catalog catalog);

    List<Catalog> findAllCatalogsByProduct(Product product);

//    List<Product> findProductByMinPrise(Catalog catalog);
//
//    List<Product> findProductByMaxPrise(Catalog catalog);
//
//    List<Product> findProductByMaxAndMinPrice(Catalog catalog);
}
