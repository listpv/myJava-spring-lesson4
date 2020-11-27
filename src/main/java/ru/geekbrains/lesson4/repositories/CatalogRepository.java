package ru.geekbrains.lesson4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.CatalogEntry;
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


    @Query("SELECT c FROM Catalog c JOIN c.catalogEntries ce WHERE ce.product = :product")
    List<Catalog> findCatalogsByProductEquals(@Param("product") Product product);

    List<CatalogEntry> findAllByName(String string);

    @Query("SELECT catalogEntries FROM Catalog WHERE name = :name")
    List<CatalogEntry> findCatalogEntries(@Param("name") String name);

    @Query("SELECT MAX(cp.price) FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE c.name = :name")
    Double findMaxPriceInCatalog(@Param("name") String name);

    @Query("SELECT MIN(cp.price) FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE c.name = :name")
    Double findMinPriceInCatalog(@Param("name") String name);

    @Query("SELECT cp FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE cp.price = " +
            "(SELECT MAX(cp.price) FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE c.name = :name) " +
            "AND c.name = :name")
    List<Product> findProductsInCatalogWithMaxPrice(@Param("name") String name);

    @Query("SELECT cp FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE cp.price = " +
            "(SELECT MIN(cp.price) FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE c.name = :name) " +
            "AND c.name = :name")
    List<Product> findProductsInCatalogWithMinPrice(@Param("name") String name);

    @Query("SELECT cp FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE c.name = :name AND (cp.price = " +
            "(SELECT MIN(cp.price) FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE c.name = :name) " +
            "OR cp.price = (SELECT MAX(cp.price) FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE c.name = :name))")
    List<Product> findProductsInCatalogWithMinAndMaxPrice(@Param("name") String name);

    List<Catalog> findAll();




//    @Query("SELECT MAX(ce.price) FROM CatalogEntry ce")
//    Double findMaxPriceFromCatalog(List<CatalogEntry> catalogEntryList);

//    @Query("SELECT MAX(ce.price) FROM Catalog.catalogEntries ce WHERE Catalog.name = :name")
//    Double findMaxPriceFromCatalog1(@Param("name") String string);


//    List<Catalog> findCatalogsByProductsEquals(Product product);
}
