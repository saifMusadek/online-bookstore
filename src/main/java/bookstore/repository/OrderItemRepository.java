package bookstore.repository;

import bookstore.domain.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderItemRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(OrderItem orderItem) {
        sessionFactory.getCurrentSession().save(orderItem);
    }

    public void delete(OrderItem orderItem) {
        sessionFactory.getCurrentSession().delete(orderItem);
    }

    public List<OrderItem> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from OrderItem", OrderItem.class).list();
    }

    public OrderItem getById(Integer id) {
        return sessionFactory.getCurrentSession().get(OrderItem.class, id);
    }

    public boolean update(OrderItem orderItem) {
        Session session = sessionFactory.getCurrentSession();
        session.update(orderItem);
        return true;
    }

    public List<OrderItem> getByOrderId (Integer id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<OrderItem> query = session.createQuery("SELECT oi FROM OrderItem oi JOIN FETCH oi.book WHERE oi.order.id = :orderId", OrderItem.class);
        query.setParameter("orderId", id);


        return  query.getResultList();
    }
}
