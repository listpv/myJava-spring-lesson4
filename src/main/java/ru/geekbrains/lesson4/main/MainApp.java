package ru.geekbrains.lesson4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.geekbrains.lesson4.config.AppConfig;
import ru.geekbrains.lesson4.entity.Catalog;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.repositories.CatalogPaginationRepository;
import ru.geekbrains.lesson4.repositories.ProductPaginationRepository;
import ru.geekbrains.lesson4.services.CatalogEntryService;
import ru.geekbrains.lesson4.services.CatalogService;
import ru.geekbrains.lesson4.services.ProductService;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CatalogService catalogService = applicationContext.getBean("catalogService", CatalogService.class);
        CatalogEntryService catalogEntryService =applicationContext.getBean("catalogEntryService", CatalogEntryService.class);
        ProductService productService = applicationContext.getBean("productService", ProductService.class);
        CatalogPaginationRepository catalogPaginationRepository =
                applicationContext.getBean("catalogPaginationRepository", CatalogPaginationRepository.class);
        ProductPaginationRepository productPaginationRepository =
                applicationContext.getBean("productPaginationRepository", ProductPaginationRepository.class);


        Product product1= new Product("product1", 10.0);
        Product product2= new Product("product2", 20.0);
        Product product3= new Product("product3", 30.0);
        Product product4= new Product("product4", 40.0);
        Product product5= new Product("product5", 50.0);
        Product product6= new Product("product6", 60.0);
        Product product7= new Product("product7", 70.0);
        Product product8= new Product("product8", 50.0);
        Product product9= new Product("product9", 90.0);
        Product product10= new Product("product10", 100.0);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
        productService.save(product5);
        productService.save(product6);
        productService.save(product7);
        productService.save(product8);
        productService.save(product9);
        productService.save(product10);


        Catalog catalog1 = new Catalog("Catalog1");
        Catalog catalog2 = new Catalog("Catalog2");
        Catalog catalog3 = new Catalog("Catalog3");
        Catalog catalog4 = new Catalog("Catalog4");
        Catalog catalog5 = new Catalog("Catalog5");

        catalogService.save(catalog1);
        catalogService.save(catalog2);
        catalogService.save(catalog3);
        catalogService.save(catalog4);
        catalogService.save(catalog5);

        catalogEntryService.addProduct(catalog1, product1);
        catalogEntryService.addProduct(catalog1, product2);
        catalogEntryService.addProduct(catalog1, product3);
        catalogEntryService.addProduct(catalog1, product4);
        catalogEntryService.addProduct(catalog2, product5);
        catalogEntryService.addProduct(catalog2, product6);
        catalogEntryService.addProduct(catalog2, product7);
        catalogEntryService.addProduct(catalog2, product8);
        catalogEntryService.addProduct(catalog3, product9);
        catalogEntryService.addProduct(catalog3, product10);
        catalogEntryService.addProduct(catalog3, product1);
        catalogEntryService.addProduct(catalog3, product2);
        catalogEntryService.addProduct(catalog4, product3);
        catalogEntryService.addProduct(catalog4, product4);
        catalogEntryService.addProduct(catalog4, product5);
        catalogEntryService.addProduct(catalog4, product6);
        catalogEntryService.addProduct(catalog5, product7);
        catalogEntryService.addProduct(catalog5, product8);
        catalogEntryService.addProduct(catalog5, product9);
        catalogEntryService.addProduct(catalog5, product10);


        //  все  каталоги с товарами.
        System.out.println(catalogService.findAll());

        //  все  каталоги с товарами постранично.
        Pageable pageable1 = PageRequest.of(0, 2);
        Page<Catalog> catalogPage1 = catalogPaginationRepository.findAll(pageable1);
        Pageable pageable2 = PageRequest.of(1, 2);
        Page<Catalog> catalogPage2 = catalogPaginationRepository.findAll(pageable2);
        Pageable pageable3 = PageRequest.of(2, 2);
        Page<Catalog> catalogPage3 = catalogPaginationRepository.findAll(pageable3);
        System.out.println(catalogPage1.getContent());
        System.out.println(catalogPage2.getContent());
        System.out.println(catalogPage3.getContent());

//        Pageable pageable1 = PageRequest.of(0, 2);
//        Page<Product> productPage1 = productPaginationRepository.findAll(pageable1);
//        System.out.println(productPage1);
//        Pageable pageable2 = PageRequest.of(1, 2);
//        Page<Product> productPage2 = productPaginationRepository.findAll(pageable2);
//        System.out.println(productPage2);

        // максимальная ценой из общего списка.
        Double maxPrice = productService.findMaxPrice();
        System.out.println("MaxPrice is --- " + maxPrice);

        // минимальная ценой из общего списка.
        Double minPrice = productService.findMinPrice();
        System.out.println("MinPrice is --- " + minPrice);

        // продукты с максимальной ценой определённого каталога.
        List<Product> productListInCatalogWithMaxPrice = catalogService.findProductsInCatalogWithMaxPrice("Catalog1");
        System.out.println("ProductListInCatalogWithMaxPrice " + productListInCatalogWithMaxPrice);

        // продукты с минимальной ценой определённого каталога.
        List<Product> productListInCatalogWithMinPrice = catalogService.findProductsInCatalogWithMinPrice("Catalog1");
        System.out.println("ProductListInCatalogWithMinPrice " + productListInCatalogWithMinPrice);

        // продукты с максимальной и минимальной ценой определённого каталога.
        List<Product> productListInCatalogWithMinAndMaxPrice = catalogService.findProductsInCatalogWithMinAndMaxPrice("Catalog1");
        System.out.println("ProductListInCatalogWithMinAndMaxPrice " + productListInCatalogWithMinAndMaxPrice);

        // продукты с максимальной ценой из общего списка.
        List<Product> productListWithMaxPrice = productService.findProductsByMaxPrice();
        System.out.println("ProductListWithMaxPrice " + productListWithMaxPrice);

        // продукты с минимальной ценой из общего списка.
        List<Product> productListWithMinPrice = productService.findProductsByMinPrice();
        System.out.println("ProductListWithMinPrice " + productListWithMinPrice);

        // продукты с указанной ценой из общего списка.
        List<Product> productByPrice = productService.findProductByPriceEquals(50.0);
        System.out.println("ProductByPrice " + productByPrice);

        // каталоги с указанным продуктом.
        List<Catalog> catalogList = catalogService.findCatalogsByProductsEquals(product3);
        System.out.println("catalogList " + catalogList);

//        Double catMaxPrice = catalogService.findMaxPriceFromCatalog("Catalog1");
//        System.out.println( "catMaxPrice --- " + catMaxPrice);
//
//        Double catMinPrice = catalogService.findMinPriceFromCatalog("Catalog1");
//        System.out.println( "catMinPrice --- " + catMinPrice);

        // максимальная цена в каталоге.
        Double maxPriceInCatalog = catalogService.findMaxPriceInCatalog("Catalog1");
        System.out.println( "MaxPriceInCatalog --- " + maxPriceInCatalog);

        // минимальная цена в каталоге.
        Double minPriceInCatalog = catalogService.findMinPriceInCatalog("Catalog1");
        System.out.println( "MinPriceInCatalog --- " + minPriceInCatalog);

    }
}
