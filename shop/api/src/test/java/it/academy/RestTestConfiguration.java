package it.academy;


import it.academy.dao.ProductDao;
import it.academy.dao.ProductDaoImpl;
import it.academy.model.Product;
import it.academy.service.ProductService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
@ComponentScan(value = "it.academy.rest")
@Profile("test")
public class RestTestConfiguration {

    @Bean
    @Primary
    public ProductService productService(){
        ProductService productService= Mockito.mock(ProductService.class);

        Mockito.when(productService.findAllProducts())
                .thenReturn(List.of(new Product()));
        return productService;
    }

    @Bean
    public ProductDao productDao(){
        return Mockito.mock(ProductDaoImpl.class);
    }
}
