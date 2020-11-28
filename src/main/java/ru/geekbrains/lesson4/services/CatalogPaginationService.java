package ru.geekbrains.lesson4.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

public interface CatalogPaginationService {

    List<Product> findAllProductsFromCatalog(String name, Pageable pageable);

    List<Catalog> findAllCatalogs(Pageable pageable);
}

