package ru.geekbrains.lesson4.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.CatalogEntry;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.repositories.CatalogEntryRepository;
import ru.geekbrains.lesson4.services.CatalogEntryService;
import ru.geekbrains.lesson4.services.CatalogService;

import java.util.List;

@Service("catalogEntryService")
public class CatalogEntryServiceImpl implements CatalogEntryService {

    protected CatalogEntryRepository catalogEntryRepository;

    @Autowired
    public void setCatalogEntryRepository(CatalogEntryRepository catalogEntryRepository) {
        this.catalogEntryRepository = catalogEntryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public CatalogEntry get(Long id) {
        return catalogEntryRepository.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CatalogEntry> getAll() {
        return catalogEntryRepository.findAll();
    }

    @Override
    @Transactional
    public void save(CatalogEntry catalogEntry) {
        catalogEntryRepository.save(catalogEntry);
    }

    @Override
    @Transactional
    public void remove(CatalogEntry catalogEntry) {
        catalogEntryRepository.delete(catalogEntry);
    }

    @Override
    @Transactional(readOnly = true)
    public CatalogEntry addProduct(Catalog catalog, Product product) {
        CatalogEntry catalogEntry = new CatalogEntry();
        catalogEntry.setCatalog(catalog);
        catalogEntry.setPrice(product.getPrice());
        catalogEntry.setProduct(product);
        return catalogEntryRepository.save(catalogEntry);
    }
}
