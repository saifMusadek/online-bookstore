package bookstore.repository;

import bookstore.domain.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(CartItem cartItem) {
        sessionFactory.getCurrentSession().save(cartItem);
    }

    public void delete(CartItem cartItem) {
        sessionFactory.getCurrentSession().delete(cartItem);
    }

    public List<CartItem> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from CartItem", CartItem.class).list();
    }

    public CartItem getById(Integer id) {
        return sessionFactory.getCurrentSession().get(CartItem.class, id);
    }

    public boolean update(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.update(cartItem);
        return true;
    }
}
