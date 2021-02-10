package it.academy.dao;

import it.academy.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static List<Product> products=List.of(
        Product.builder()
                .productId("1")
                .productName("Apple iPhone 12")
                .description("256 Gb white")
                .build(),
            Product.builder()
                    .productId("2")
                    .productName("Apple Ipad")
                    .description("32 Gb black")
                    .build(),
            Product.builder()
                    .productId("3")
                    .productName("Samsung Galaxy X")
                    .description("64 Gb Gray Space")
                    .build()
            );


    @Override
    public List<Product> findAllProducts() {
        return products;
    }
}
