package it.academy.dao;

import com.mysql.cj.jdbc.Driver;
import it.academy.model.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@PropertySource(value = "classpath:datasource.properties")
@Configuration
public class DaoConfiguration {


    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(env.getProperty("datasource.url"));
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUsername(env.getProperty("datasource.username"));
        dataSource.setPassword(env.getProperty("datasource.password"));
        dataSource.setInitialSize(20);
        dataSource.setMaxTotal(30);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setAnnotatedClasses(
                Person.class, Product.class, ProductPrice.class, Promo.class, ShopUser.class
        );
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }
}
