package it.academy.dao;

import it.academy.model.VisitorCount;

public interface VisitorCountDao {

    VisitorCount read(int id);

    Integer update(VisitorCount visitorCount);
}
