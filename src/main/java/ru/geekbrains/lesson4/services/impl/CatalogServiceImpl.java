package ru.geekbrains.lesson4.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.CatalogEntry;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.repositories.CatalogRepository;
import ru.geekbrains.lesson4.services.CatalogService;

import java.util.ArrayList;
import java.util.List;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {

    CatalogRepository catalogRepository;


    @Autowired
    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public Catalog get(Long id) {
        return catalogRepository.getOne(id);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Catalog> getAll() {
        return catalogRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    @Transactional
    public void remove(Catalog catalog) {
        catalogRepository.delete(catalog);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CatalogEntry> findAllByName(String string) {
        return catalogRepository.findAllByName(string);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CatalogEntry> findCatalogEntries(String name){
        return catalogRepository.findCatalogEntries(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Double findMaxPriceFromCatalog(String name) {
        List<CatalogEntry> catalogEntryList = findCatalogEntries(name);
        Double price = 0.0;
        for(CatalogEntry o : catalogEntryList){
            Double tempPrice = o.getProduct().getPrice();
            if(tempPrice > price){
                price = tempPrice;
            }
        }
        return price;
    }

    @Override
    @Transactional(readOnly = true)
    public Double findMinPriceFromCatalog(String name) {
        List<CatalogEntry> catalogEntryList = findCatalogEntries(name);
        Double price = catalogEntryList.get(0).getProduct().getPrice();
        for(CatalogEntry o : catalogEntryList){
            Double tempPrice = o.getProduct().getPrice();
            if(tempPrice < price){
                price = tempPrice;
            }
        }
        return price;
    }

    @Override
    @Transactional(readOnly = true)
    public Double findMaxPriceInCatalog(String name) {
        return catalogRepository.findMaxPriceInCatalog(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Double findMinPriceInCatalog(String name) {
        return catalogRepository.findMinPriceInCatalog(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductsInCatalogWithMaxPrice(String name) {
        return catalogRepository.findProductsInCatalogWithMaxPrice(name);
    }

    @Override
    public List<Product> findProductsInCatalogWithMinPrice(String name) {
        return catalogRepository.findProductsInCatalogWithMinPrice(name);
    }

    @Override
    public List<Product> findProductsInCatalogWithMinAndMaxPrice(String name) {
        return catalogRepository.findProductsInCatalogWithMinAndMaxPrice(name);
    }

    @Override
    public List<Product> findAllProductsFromCatalog(String name) {
        return catalogRepository.findAllProductsFromCatalog(name);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Catalog> findCatalogsByProductsEquals(Product product) {
        return catalogRepository.findCatalogsByProductEquals(product);
    }



}
