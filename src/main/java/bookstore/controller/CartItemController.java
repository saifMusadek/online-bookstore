package bookstore.controller;

import bookstore.domain.CartItem;
import bookstore.domain.Order;
import bookstore.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/cartItems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public void createCartItem(@RequestBody CartItem cartItem) {
        cartItemService.save(cartItem);
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAll();
    }

    @GetMapping("/{id}")
    public CartItem getCartItemById(@PathVariable Integer id) {
        return cartItemService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateCartItem(@PathVariable Integer id, @RequestBody CartItem cartItem) {
        CartItem existingCartItem = cartItemService.getById(id);
        if (existingCartItem != null) {
            cartItem.setId(id);
            cartItemService.update(cartItem);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable Integer id) {
        CartItem cartItem = cartItemService.getById(id);
        if (cartItem != null) {
            cartItemService.delete(cartItem);
        }
    }


    @PostMapping("/update-quantity")
    public String updateQuantity(@RequestParam("bookId") int bookId, @RequestParam("quantity") int quantity, HttpSession session) {
        // Retrieve the cart items from the session
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItems != null) {
            // Find the cart item with the matching book ID
            for (CartItem cartItem : cartItems) {
                if (cartItem.getBook().getId() == bookId) {
                    // Update the quantity if it is available from the book quantity
                    if (quantity <= cartItem.getBook().getQuantity()) {
                        cartItem.setQuantity(quantity);
                    }
                    break;
                }
            }
            // Update the session with the modified cart items
            session.setAttribute("cartItems", cartItems);
        }

        // Redirect back to the cart view
        return "redirect:../cart/view-cart";
    }
    @PostMapping("/remove-book")
    public String removeBook(@RequestParam("bookId") int bookId, HttpSession session) {
        // Retrieve the cart items from the session
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItems != null) {
            // Iterate over the cart items and remove the one with the matching book ID
            Iterator<CartItem> iterator = cartItems.iterator();
            while (iterator.hasNext()) {
                CartItem cartItem = iterator.next();
                if (cartItem.getBook().getId() == bookId) {
                    iterator.remove();
                    break;
                }
            }
            // Update the session with the modified cart items
            session.setAttribute("cartItems", cartItems);
        }

        // Redirect back to the cart view
        return "redirect:../cart/view-cart";

    }

}
