package it.academy.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder
public class ProductTest {

    private SessionFactory factory;
    @Before
    public void setUp() throws Exception {
        StandardServiceRegistry registry =new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.test.xml")
                .build();
        factory=new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

    }

    @Test
    public void create(){
//        given
        Product product=new Product();
        product.setProductName("Apple iPhone");
        product.setDescription("iPhone 12 512GB");

        ProductPrice productPrice1=new ProductPrice();
        productPrice1.setProduct(product);
        productPrice1.setPriceValue(BigDecimal.valueOf(5990.99));
        productPrice1.setCurrency(ProductPrice.Currency.BYN);

        ProductPrice productPrice2=new ProductPrice();
        productPrice2.setProduct(product);
        productPrice2.setPriceValue(BigDecimal.valueOf(2000.22));
        productPrice2.setCurrency(ProductPrice.Currency.USD);

        List<ProductPrice> prices =new ArrayList<>();
        prices.add(productPrice1);
        prices.add(productPrice2);
        product.setProductPrice(prices);

        //When
        Session session=factory.openSession();
        Serializable id = null;
        Transaction tx=null;
        try {
            tx = session.beginTransaction();
            //do some work
            session.save(productPrice1);
            session.save(productPrice2);
            id=session.save(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        //Then
//        assertNotNull(id);

    }

}