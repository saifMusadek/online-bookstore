package bookstore.repository;

import bookstore.domain.DeliveryHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DeliveryHistoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(DeliveryHistory deliveryHistory) {
        sessionFactory.getCurrentSession().save(deliveryHistory);
    }

    public void delete(DeliveryHistory deliveryHistory) {
        sessionFactory.getCurrentSession().delete(deliveryHistory);
    }

    public List<DeliveryHistory> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM DeliveryHistory").list();
    }

    public DeliveryHistory getById(Integer id) {
        return sessionFactory.getCurrentSession().get(DeliveryHistory.class, id);
    }

    public List<DeliveryHistory> getByDeliveryManId(Integer deliveryManId) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<DeliveryHistory> query = session.createQuery("FROM DeliveryHistory WHERE deliveryMan.id = :deliveryManId", DeliveryHistory.class);
        query.setParameter("deliveryManId", deliveryManId);
        return query.getResultList();
    }

    public boolean update(DeliveryHistory deliveryHistory) {
        Session session = sessionFactory.getCurrentSession();
        session.update(deliveryHistory);
        return true;
    }
}
