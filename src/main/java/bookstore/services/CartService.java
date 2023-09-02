package bookstore.services;

import bookstore.domain.Cart;
import bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void save(Cart cart) {
        if (cart != null) {
            cartRepository.save(cart);
        }
    }

    public void delete(Cart cart) {
        if (cart != null) {
            cartRepository.delete(cart);
        }
    }

    public List<Cart> getAll() {
        return cartRepository.getAll();
    }

    public Cart getById(Integer id) {
        if (id != null) {
            return cartRepository.getById(id);
        }
        return null;
    }

    public boolean update(Cart cart) {
        if (cart != null) {
            return cartRepository.update(cart);
        }
        return false;
    }
}
