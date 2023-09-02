package bookstore.controller;

import bookstore.domain.Cart;
import bookstore.domain.CartItem;
import bookstore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public void createCart(@RequestBody Cart cart) {
        cartService.save(cart);
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAll();
    }

    @GetMapping("/cart/{id}")
    public Cart getCartById(@PathVariable Integer id) {
        return cartService.getById(id);
    }


    @PutMapping("/cart/{id}")
    public void updateCart(@PathVariable Integer id, @RequestBody Cart cart) {
        Cart existingCart = cartService.getById(id);
        if (existingCart != null) {
            cart.setId(id);
            cartService.update(cart);
        }
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable Integer id) {
        Cart cart = cartService.getById(id);
        if (cart != null) {
            cartService.delete(cart);
        }
    }
    @GetMapping("/cart/view-cart")
    public String viewCart(HttpSession session, Model model) {
        // Retrieve the cartItems list from the session
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");

        model.addAttribute("cartItems", cartItems);
        return "cart/cart";
    }

}
