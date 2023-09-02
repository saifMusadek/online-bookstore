package bookstore.repository;

import bookstore.domain.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(UserRole role) {
        sessionFactory.getCurrentSession().save(role);
    }

    public void delete(UserRole role) {
        sessionFactory.getCurrentSession().delete(role);
    }

    public List<UserRole> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Role", UserRole.class).list();
    }

    public UserRole getById(Integer id) {
        return sessionFactory.getCurrentSession().get(UserRole.class, id);
    }

    public boolean update(UserRole role) {
        Session session = sessionFactory.getCurrentSession();
        session.update(role);
        return true;
    }
}
