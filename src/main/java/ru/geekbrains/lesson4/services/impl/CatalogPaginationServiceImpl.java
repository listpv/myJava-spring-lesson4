package ru.geekbrains.lesson4.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.repositories.CatalogPaginationRepository;
import ru.geekbrains.lesson4.services.CatalogPaginationService;

import java.util.List;

@Service("catalogPaginationService")
public class CatalogPaginationServiceImpl implements CatalogPaginationService {


    private CatalogPaginationRepository catalogPaginationRepository;

    @Autowired
    public void setCatalogPaginationRepository(CatalogPaginationRepository catalogPaginationRepository) {
        this.catalogPaginationRepository = catalogPaginationRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllProductsFromCatalog(String name, Pageable pageable) {
        return catalogPaginationRepository.findAllProductsFromCatalog(name, pageable);
    }

    @Override
    public List<Catalog> findAllCatalogs(Pageable pageable) {
        return catalogPaginationRepository.findAllCatalogs(pageable);
    }
}
