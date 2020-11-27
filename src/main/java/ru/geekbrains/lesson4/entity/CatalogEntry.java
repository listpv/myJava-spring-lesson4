package ru.geekbrains.lesson4.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "catalogentry")
public class CatalogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private Double price;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogEntry that = (CatalogEntry) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//    @Override
//    public String toString() {
//        return "CatalogEntry{" +
//                "id=" + id +
//                ", price=" + price +
//                ", product=" + product +
//                '}';
//    }


    @Override
    public String toString() {
        return ("product = " + product);
    }
}
