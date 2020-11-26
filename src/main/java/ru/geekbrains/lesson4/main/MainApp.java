package ru.geekbrains.lesson4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.lesson4.config.AppConfig;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.services.CatalogService;
import ru.geekbrains.lesson4.services.ProductService;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CatalogService catalogService = applicationContext.getBean("catalogService", CatalogService.class);
        ProductService productService = applicationContext.getBean("productService", ProductService.class);

        Product product1= new Product("product1", 10.0);
        Product product2= new Product("product2", 20.0);
        Product product3= new Product("product3", 30.0);
        Product product4= new Product("product4", 40.0);
        Product product5= new Product("product5", 50.0);
        Product product6= new Product("product6", 60.0);
        Product product7= new Product("product7", 70.0);
        Product product8= new Product("product8", 80.0);
        Product product9= new Product("product9", 90.0);
        Product product10= new Product("product10", 100.0);

        Catalog catalog1 = new Catalog("Catalog1");
        Catalog catalog2 = new Catalog("Catalog2");
        Catalog catalog3 = new Catalog("Catalog3");
        Catalog catalog4 = new Catalog("Catalog4");
        Catalog catalog5 = new Catalog("Catalog5");

        catalog1.addProduct(product1);
        catalog1.addProduct(product2);
        catalog1.addProduct(product3);
        catalog1.addProduct(product4);

        catalog2.addProduct(product5);
        catalog2.addProduct(product6);
        catalog2.addProduct(product7);
        catalog2.addProduct(product8);
        catalog2.addProduct(product9);

        catalog3.addProduct(product9);
        catalog3.addProduct(product10);
        catalog3.addProduct(product1);
        catalog3.addProduct(product2);

        catalog4.addProduct(product3);
        catalog4.addProduct(product4);
        catalog4.addProduct(product5);

        catalog5.addProduct(product7);
        catalog5.addProduct(product8);
        catalog5.addProduct(product9);
        catalog5.addProduct(product10);


        catalogService.save(catalog1);
        catalogService.save(catalog2);
        catalogService.save(catalog3);
        catalogService.save(catalog4);
        catalogService.save(catalog5);

        Double spPrice = productService.findMaxPrice();
        System.out.println("Price is --- " + spPrice);

        List<Product> spProduct = productService.findProductByPriceEquals(50.0);
        System.out.println(spProduct);




    }
}
