package bookstore.repository;

import bookstore.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    public void delete(Book book) {
        sessionFactory.getCurrentSession().delete(book);
    }

    public List<Book> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Book", Book.class).list();
    }

    public Book getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    public boolean update(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        return true;
    }
}
