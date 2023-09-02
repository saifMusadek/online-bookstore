package bookstore.repository;

import bookstore.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void delete(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    public List<Order> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Order", Order.class).list();
    }


    public List<Order>getAllPendingOrders(){
            Session session = sessionFactory.getCurrentSession();
            TypedQuery<Order> query = session.createQuery("SELECT o FROM Order o WHERE o.orderStatus = 'pending'", Order.class);


        return query.getResultList();
        }

    public Order getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }

    public boolean update(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
        return true;
    }
    public boolean updateOrderStatus3(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Order order = session.get(Order.class, id);
            if (order != null) {
                order.setOrderStatus("completed");
                session.update(order);
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

    public boolean updateOrderStatus2(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Order order = session.get(Order.class, id);
            if (order != null) {
                order.setOrderStatus("on the way");
                session.update(order);
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
    public boolean updateOrderStatus(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Order order = session.get(Order.class, id);
            if (order != null) {
                order.setOrderStatus("processing");
                session.update(order);
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



    public  int getMaxId()
    {

        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Integer> query = session.createQuery("select max(id) from Order", Integer.class);
        try {
            return query.getSingleResult();

        } catch ( NullPointerException exception) {
            return 0; // User not found
        }

    }

    public List<Order> getByUserId(int userId) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.createQuery("SELECT o FROM Order o WHERE o.user.id = :userId", Order.class);
        query.setParameter("userId", userId);

        return query.getResultList();
    }

}
