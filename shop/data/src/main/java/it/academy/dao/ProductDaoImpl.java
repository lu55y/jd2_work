package it.academy.dao;

import it.academy.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static List<Product> products = List.of(
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

    @Override
    public Product read(String id) {
        return products.stream()
                .filter(product -> product.getProductId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public String save(Product product) {
        int maxId=products.stream()
                .max((o1, o2) -> Integer.valueOf(o1.getProductId())-Integer.valueOf(o2.getProductId()))
                .map(product1 -> Integer.valueOf(product1.getProductId()))
                .get();
        String productId =String.valueOf(++maxId);
        product.setProductId(productId);
        products=new ArrayList<>(products);
        products.add(product);
        return productId;
    }
}
