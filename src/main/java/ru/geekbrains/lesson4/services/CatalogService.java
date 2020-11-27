package ru.geekbrains.lesson4.services;

import org.springframework.data.repository.query.Param;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.CatalogEntry;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.repositories.CatalogRepository;

import java.util.List;

public interface CatalogService {

    Catalog get(Long id);
    List<Catalog> getAll();
    void save(Catalog catalog);
    void remove(Catalog catalog);

    List<CatalogEntry> findAllByName(String string);

    List<CatalogEntry> findCatalogEntries(String name);

    Double findMaxPriceFromCatalog(String name);

    Double findMinPriceFromCatalog(String name);

    Double findMaxPriceInCatalog(String name);

    Double findMinPriceInCatalog(String name);

    List<Catalog> findAll();

    List<Product> findProductsInCatalogWithMaxPrice( String name);

    List<Product> findProductsInCatalogWithMinPrice(String name);

    List<Product> findProductsInCatalogWithMinAndMaxPrice(String name);

    List<Product> findAllProductsFromCatalog(String name);


    List<Catalog> findCatalogsByProductsEquals(Product product);
}
