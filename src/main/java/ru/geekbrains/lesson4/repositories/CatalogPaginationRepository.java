package ru.geekbrains.lesson4.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Catalog;

@Repository
public interface CatalogPaginationRepository extends PagingAndSortingRepository<Catalog, Long> {
}
