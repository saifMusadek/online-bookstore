package bookstore.repository;

import bookstore.domain.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    public void delete(Author author) {
        sessionFactory.getCurrentSession().delete(author);
    }

    public List<Author> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Author", Author.class).list();
    }

    public Author getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Author.class, id);
    }

    public boolean update(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.update(author);
        return true;
    }



}
