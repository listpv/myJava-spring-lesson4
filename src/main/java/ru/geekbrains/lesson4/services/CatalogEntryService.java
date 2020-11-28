package ru.geekbrains.lesson4.services;

import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.CatalogEntry;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

public interface CatalogEntryService {

    CatalogEntry get(Long id);
    List<CatalogEntry> getAll();
    void save(CatalogEntry catalogEntry);
    void remove(CatalogEntry catalogEntry);
    CatalogEntry addProduct(Catalog catalog, Product product);
}
