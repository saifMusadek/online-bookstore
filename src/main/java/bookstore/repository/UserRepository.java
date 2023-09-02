package bookstore.repository;

import bookstore.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public User getById(Integer id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    public User getUserName(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> UserQuery = session.createQuery("from User Where username = :username", User.class);
        UserQuery.setParameter("username", username);
        return UserQuery.getSingleResult();
    }

    public Integer getIdByUserName(String username){
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Integer> userQuery = session.createQuery("SELECT u.id FROM User u WHERE u.username = :username", Integer.class);
        userQuery.setParameter("username", username);
        return userQuery.getSingleResult();

    }

    public String getPasswordByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<String> passwordQuery = session.createQuery("select password from User where username = :username", String.class);
        passwordQuery.setParameter("username", username);
        passwordQuery.setMaxResults(1); // Limit the result to 1

        try {
            return passwordQuery.getSingleResult();
        } catch (NoResultException e) {
            return null; // User not found
        }
    }
    public User get(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> userQuery = session.createQuery("from User Where username = :username", User.class);
        userQuery.setParameter("username", username);
        return userQuery.getSingleResult();
    }


    public boolean update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return true;
    }


        public String findRole(String username) {
            Session session = sessionFactory.getCurrentSession();
            Query<Integer> query = session.createQuery(
                    "SELECT u.role.id FROM User u WHERE u.username = :username", Integer.class
            );
            query.setParameter("username", username);
            Integer roleId = query.uniqueResult();

            String role;
            if (roleId == 1) {
                role = "admin";
            } else if (roleId == 2) {
                role = "customer";
            } else {
                role = "delivery";
            }
        return role;
    }




























}
