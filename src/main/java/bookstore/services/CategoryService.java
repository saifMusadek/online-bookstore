package bookstore.services;

import bookstore.domain.Category;
import bookstore.domain.User;
import bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void save(Category category) {
        if (category != null) {
            categoryRepository.save(category);
        }
    }

    public void delete(Category category) {
        if (category != null) {
            categoryRepository.delete(category);
        }
    }

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Category getById(Integer id) {
        if (id != null) {
            return categoryRepository.getById(id);
        }
        return null;
    }

    public boolean update(Category category) {
        if (category != null) {
            return categoryRepository.update(category);
        }
        return false;
    }

    public boolean updateCategory(Category category) {
        return categoryRepository.update(category);
    }
}
