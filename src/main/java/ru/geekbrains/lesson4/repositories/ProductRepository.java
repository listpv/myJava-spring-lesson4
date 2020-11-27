package ru.geekbrains.lesson4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT MAX(price) FROM Product")
    Double findMaxPrice();

    @Query("SELECT MIN(price) FROM Product")
    Double findMinPrice();

    @Query("SELECT p FROM Product p WHERE p.price = (SELECT MAX(price) FROM Product )")
    List<Product> findProductsByMaxPrice();

    @Query("SELECT p FROM Product p WHERE p.price = (SELECT MIN(price) FROM Product )")
    List<Product> findProductsByMinPrice();

    List<Product> findProductByPriceEquals(Double price);


    Product findByName(String name);

}
