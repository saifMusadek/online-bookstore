package bookstore.services;

import bookstore.domain.Book;
import bookstore.domain.Category;
import bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book) {
        if (book != null) {
            bookRepository.save(book);
        }
    }

    public void delete(Book book) {
        if (book != null) {
            bookRepository.delete(book);
        }
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public Book getById(Integer id) {
        if (id != null) {
            return bookRepository.getById(id);
        }
        return null;
    }

    public boolean update(Book book) {
        if (book != null) {
            return bookRepository.update(book);
        }
        return false;
    }

    public boolean updateBook(Book book) {
        return bookRepository.update(book);
    }
}
