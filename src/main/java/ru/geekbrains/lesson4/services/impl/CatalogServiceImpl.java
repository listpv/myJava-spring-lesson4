package ru.geekbrains.lesson4.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.lesson4.entity.Catalog;
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
    public Catalog get(Long id) {
        return catalogRepository.getOne(id);
    }


    @Override
    public List<Catalog> getAll() {
        return catalogRepository.findAll();
    }

    @Override
    public void save(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public void remove(Catalog catalog) {
        catalogRepository.delete(catalog);
    }

//    @Override
//    public Long findMinPrise(Catalog catalog) {
//        return catalogRepository.findMinPrice(catalog);
//    }
//
//    @Override
//    public Long findMaxPrise(Catalog catalog) {
//        return catalogRepository.findMaxPrice(catalog);
//    }

    @Override
    public List<Catalog> findAllCatalogsByProduct(Product product) {
        return catalogRepository.findAllCatalogsByProduct(product);
    }

//    @Override
//    public List<Product> findProductByMinPrise(Catalog catalog) {
//       return catalogRepository.findProductByPriceIs(findMinPrise(catalog));
//    }
//
//    @Override
//    public List<Product> findProductByMaxPrise(Catalog catalog) {
//        return catalogRepository.findProductByPriceIs(findMaxPrise(catalog));
//    }
//
//    @Override
//    public List<Product> findProductByMaxAndMinPrice(Catalog catalog) {
//        List<Product> distProducts = new ArrayList<>();
//        distProducts.addAll(findProductByMinPrise(catalog));
//        distProducts.addAll(findProductByMaxPrise(catalog));
//        return distProducts;
//    }


}
