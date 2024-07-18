package com.samplewakefit.dao;

import com.samplewakefit.model.Furniture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class FurnitureDAO {
    private final SessionFactory sessionFactory;

    public FurnitureDAO() {
        Configuration configuration = new Configuration().configure("hibernatecfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public void saveFurniture(Furniture furniture) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(furniture);
        session.getTransaction().commit();
        session.close();
    }

    public List<Furniture> getAllFurniture() {
        Session session = sessionFactory.openSession();
        List<Furniture> furnitureList = session.createQuery("FROM Furniture", Furniture.class).list();
        session.close();
        return furnitureList;
    }

    public List<Furniture> searchFurnitureByName(String name) {
        Session session = sessionFactory.openSession();
        List<Furniture> furnitureList = session.createQuery("FROM Furniture f WHERE f.name = :name", Furniture.class)
                .setParameter("name", name)
                .getResultList();
        session.close();
        return furnitureList;
    }

    public Furniture getFurnitureById(int productId) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Furniture.class, (long) productId); // Convert int to long
        } finally {
            session.close();
        }
    }

}
