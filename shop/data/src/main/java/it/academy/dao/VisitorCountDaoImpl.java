package it.academy.dao;

import it.academy.model.Product;
import it.academy.model.VisitorCount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorCountDaoImpl implements VisitorCountDao {

    private SessionFactory sessionFactory;

    @Autowired
    public VisitorCountDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public VisitorCount read(int id) {
        return sessionFactory.openSession()
                .get(VisitorCount.class, id);
    }

    @Override
    public Integer update(VisitorCount visitorCount) {
        Session session= sessionFactory.getCurrentSession();
        session.update(visitorCount);
        return 0;
    }
}
