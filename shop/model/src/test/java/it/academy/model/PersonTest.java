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
import java.sql.Date;

import static org.junit.Assert.*;

@FixMethodOrder
public class PersonTest {

    private SessionFactory factory;
    @org.junit.Before
    public void setUp() {
        StandardServiceRegistry registry =new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.test.xml")
                .build();
        factory=new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public void create(){
        //Given
        Person person=new Person();
        person.setName("Natalia");
        person.setSecondName("Ivanova");
        person.setDateOfBirth(Date.valueOf("1980-01-01"));
        person.setStatus(Person.Status.NEW);
        person.setComments(new String[]{"Comment1","Comment2"});

        ShopUser shopUser=new ShopUser();
        shopUser.setUserName("n_ivanova");
        shopUser.setPassword("secret");

        person.setShopUser(shopUser);


        //When
        Session session=factory.openSession();
        Serializable id = null;
        Transaction tx=null;
        try {
            tx = session.beginTransaction();
            //do some work
            session.save(shopUser);
            id=session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        //Then
        assertNotNull(id);


    }

    public void delete(){
//        given
        Session session=factory.openSession();
        Person person=session.get(Person.class,1L);
//        when
        Transaction tx=null;
        try {
            tx = session.beginTransaction();
            //do some work
            session.delete(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        //then
        assertNull(session.get(Person.class,1L));
        session.close();
    }
    @org.junit.After
    public void tearDown() throws Exception {
    }
}