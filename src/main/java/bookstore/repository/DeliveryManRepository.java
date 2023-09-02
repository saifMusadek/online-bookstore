package bookstore.repository;

import bookstore.domain.DeliveryMan;
import bookstore.domain.Order;
import bookstore.domain.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DeliveryManRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(DeliveryMan deliveryMan) {
        sessionFactory.getCurrentSession().save(deliveryMan);
    }

    public void delete(DeliveryMan deliveryMan) {
        sessionFactory.getCurrentSession().delete(deliveryMan);
    }

    public List<DeliveryMan> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from DeliveryMan").list();
    }

    public DeliveryMan getById(Integer id) {
        return sessionFactory.getCurrentSession().get(DeliveryMan.class, id);
    }

    public DeliveryMan getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<DeliveryMan> query = session.createQuery("from DeliveryMan where username = :username", DeliveryMan.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    public Integer getIdByUserName(String username){
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Integer> userQuery = session.createQuery("SELECT o.id FROM DeliveryMan o WHERE o.username = :username", Integer.class);
        userQuery.setParameter("username", username);
        return userQuery.getSingleResult();

    }

    public String getPasswordByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<String> query = session.createQuery("select password from DeliveryMan where username = :username", String.class);
        query.setParameter("username", username);
        query.setMaxResults(1); // Limit the result to 1

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // DeliveryMan not found
        }
    }

    public boolean update(DeliveryMan deliveryMan) {
        sessionFactory.getCurrentSession().update(deliveryMan);
        return true;
    }



    // public List<Order>getAllPendingOrders(){
    //            Session session = sessionFactory.getCurrentSession();
    //            TypedQuery<Order> query = session.createQuery("SELECT o FROM Order o WHERE o.orderStatus = 'pending'", Order.class);
    //
    //
    //        return query.getResultList();
    //        }


    public List<DeliveryMan>getAllActiveDeliveryMan(){
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<DeliveryMan> query = session.createQuery("SELECT o FROM DeliveryMan o WHERE o.status = 'active'", DeliveryMan.class);
        return query.getResultList();
    }

    public Integer getOrderId(int id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.createQuery("SELECT dm.order FROM DeliveryMan dm WHERE dm.id = :deliveryManId", Order.class);
        query.setParameter("deliveryManId", id);
        Order order = query.getSingleResult();

        if (order != null) {
            return order.getId();
        } else {
            return 0; // Return 0 if the order is not found
        }
    }

    public boolean updateStatusAndOrderId(int id_del) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                DeliveryMan deliveryMan = session.get(DeliveryMan.class, id_del);
                if (deliveryMan != null) {
                    deliveryMan.setStatus("active");
                    deliveryMan.setOrder(null);
                    session.update(deliveryMan);
                    transaction.commit();
                    return true;
                }
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }





    public boolean updateDeliveryManStatusOrderStatus(int id, int orderId) {
            Session session = sessionFactory.openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                DeliveryMan deliveryMan = session.get(DeliveryMan.class, id);
                if (deliveryMan != null) {
                    deliveryMan.setStatus("busy");
                    Order order = session.get(Order.class, orderId);
                    deliveryMan.setOrder(order);
                    session.update(deliveryMan);
                    transaction.commit();
                    return true;
                }
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            return false;
        }
    }

