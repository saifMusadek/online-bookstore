package bookstore.services;

import bookstore.domain.CartItem;
import bookstore.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public void save(CartItem cartItem) {
        if (cartItem != null) {
            cartItemRepository.save(cartItem);
        }
    }

    public void delete(CartItem cartItem) {
        if (cartItem != null) {
            cartItemRepository.delete(cartItem);
        }
    }

    public List<CartItem> getAll() {
        return cartItemRepository.getAll();
    }

    public CartItem getById(Integer id) {
        if (id != null) {
            return cartItemRepository.getById(id);
        }
        return null;
    }

    public boolean update(CartItem cartItem) {
        if (cartItem != null) {
            return cartItemRepository.update(cartItem);
        }
        return false;
    }
}
