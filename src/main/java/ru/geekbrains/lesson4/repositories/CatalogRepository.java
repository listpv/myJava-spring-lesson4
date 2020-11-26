package ru.geekbrains.lesson4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

//    @Query("SELECT MAX(cp.price) FROM Catalog c JOIN c.products cp")
//@Query("SELECT MAX(p.price) FROM Product p JOIN Catalog c WHERE c.name = :catalog")
//    @Query("SELECT c FROM Catalog c JOIN c.products cp WHERE c.name = :catalog HAVING cp.price = MAX(cp.price)")
//    Catalog findCatalogByName()
//    Long findMaxPrice(@Param("catalog") Catalog catalog );

 //   @Query("SELECT MIN(cp.price) FROM Catalog c JOIN c.products cp")
//    @Query("SELECT MIN(p.price) FROM Product p JOIN Catalog c WHERE c.name = :catalog")
//    @Query("SELECT c FROM Catalog c JOIN c.products cp WHERE c.name = :catalog HAVING cp.price = MIN(cp.price)")
//    Long findMinPrice(@Param("catalog") Catalog catalog );

//    List<Product> findProductByPriceIs(Long price);


    @Query("SELECT c FROM Catalog c WHERE c.products = :product")
    List<Catalog> findAllCatalogsByProduct(@Param("product") Product product);
}
