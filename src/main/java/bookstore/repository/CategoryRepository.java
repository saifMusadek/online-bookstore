package bookstore.repository;

import bookstore.domain.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    public void delete(Category category) {
        sessionFactory.getCurrentSession().delete(category);
    }

    public List<Category> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).list();
    }

    public Category getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    public boolean update(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
        return true;
    }
}
