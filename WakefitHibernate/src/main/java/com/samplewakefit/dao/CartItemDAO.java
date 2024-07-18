package com.samplewakefit.dao;

import com.samplewakefit.model.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CartItemDAO {
    private final SessionFactory sessionFactory;

    public CartItemDAO() {
        Configuration configuration = new Configuration().configure("hibernatecfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public void saveCartItem(CartItem cartItem) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cartItem);
        session.getTransaction().commit();
        session.close();
    }

    public List<CartItem> getAllCartItems() {
        Session session = sessionFactory.openSession();
        List<CartItem> cartItems = session.createQuery("FROM CartItem", CartItem.class).list();
        session.close();
        return cartItems;
    }

    public void clearCart() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM CartItem").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
