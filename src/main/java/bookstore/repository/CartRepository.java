package bookstore.repository;

import bookstore.domain.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Cart cart) {
        sessionFactory.getCurrentSession().save(cart);
    }

    public void delete(Cart cart) {
        sessionFactory.getCurrentSession().delete(cart);
    }

    public List<Cart> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Cart", Cart.class).list();
    }

    public Cart getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Cart.class, id);
    }

    public boolean update(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.update(cart);
        return true;
    }
}
