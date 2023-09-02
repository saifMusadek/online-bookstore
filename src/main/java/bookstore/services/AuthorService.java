package bookstore.services;

import bookstore.domain.Author;
import bookstore.domain.Category;
import bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void save(Author author) {
        if (author != null) {
            authorRepository.save(author);
        }
    }

    public void delete(Author author) {
        if (author != null) {
            authorRepository.delete(author);
        }
    }

    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    public Author getById(Integer id) {
        if (id != null) {
            return authorRepository.getById(id);
        }
        return null;
    }

    public boolean update(Author author) {
        if (author != null) {
            return authorRepository.update(author);
        }
        return false;
    }


    public boolean updateAuthor(Author author) {
        return authorRepository.update(author);
    }

}
