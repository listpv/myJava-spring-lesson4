package ru.geekbrains.lesson4.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "catalog",
            fetch = FetchType.EAGER
    )
    List<CatalogEntry> catalogEntries = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }

    public Catalog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CatalogEntry> getCatalogEntries() {
        return catalogEntries;
    }

    public void setCatalogEntries(List<CatalogEntry> catalogEntries) {
        this.catalogEntries = catalogEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return id.equals(catalog.id) &&
                Objects.equals(name, catalog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

//    @Override
//    public String toString() {
//        return "Catalog{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", catalogEntries=" + catalogEntries +
//                '}';
//    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                " " + catalogEntries +
                '}';
    }


}
