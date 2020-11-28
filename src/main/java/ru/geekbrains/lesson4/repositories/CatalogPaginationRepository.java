package ru.geekbrains.lesson4.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

@Repository
public interface CatalogPaginationRepository extends PagingAndSortingRepository<Catalog, Long> {

    @Query("SELECT cp FROM Catalog c JOIN c.catalogEntries ce JOIN ce.product cp WHERE c.name = :name")
    List<Product> findAllProductsFromCatalog(@Param("name") String name, Pageable pageable);

    @Query("SELECT c FROM Catalog c")
    List<Catalog> findAllCatalogs(Pageable pageable);
}
