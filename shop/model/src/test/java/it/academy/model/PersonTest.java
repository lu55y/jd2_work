package it.academy.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest extends BaseTest {

    @Test
    public void create() {
        //Given
        Person person = new Person();
        person.setName("Natalia");
        person.setSecondName("Ivanova");
        person.setDateOfBirth(Date.valueOf("1980-01-01"));
        person.setStatus(Status.UPDATED);
        person.setComments(new String[]{"Comment1", "Comment2"});

        ShopUser shopUser = new ShopUser();
        shopUser.setUserName("n_ivanova");
        shopUser.setPassword("secret");

        person.setShopUser(shopUser);

        //When
        Session session = factory.openSession();
        Transaction tx = null;
        Serializable id;
        try {
            tx = session.beginTransaction();
            //do some work
            id = session.save(person);
            session.save(shopUser);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        //Then
        assertNotNull(id);
    }

    @Test
    public void delete() {
        //Given:
        cleanInsert("PersonTest.xml");
        String uuid = "2c968187773a55a101773a55a3a10000";

        //When:
        Session session = factory.openSession();
        Person person = session.get(Person.class, uuid);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //do some work
            session.delete(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        // Then:
        assertNull(session.get(Person.class, uuid));
        session.close();
        deleteDataset();
    }

    @Test
    public void query() {
        //Given:
        cleanInsert("PersonTest.xml");

        //When:
        Session session = factory.openSession();
        List<Person> persons = session
                .createQuery("from Person where secondName like 'Ivan%'", Person.class)
                .list();

        //Then:
        assertEquals(1, persons.size());
        deleteDataset();
    }

}