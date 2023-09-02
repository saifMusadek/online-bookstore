package bookstore.controller;

import bookstore.domain.Book;
import bookstore.domain.CartItem;
import bookstore.domain.User;
import bookstore.services.BookService;
import bookstore.services.CartItemService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/market")
public class MarketController {



    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/get-market", method = RequestMethod.GET)
    public String addToCart(Model model){
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "/market/market";
    }
    @RequestMapping(value = "/post-market", method = RequestMethod.POST)
    public String addToCart(@RequestParam("bookId") int bookId, HttpSession session, Model model) {
        // Retrieve the user's cart from the session
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItems == null) {
            // If the cart doesn't exist in the session, create a new cart
            cartItems = new ArrayList<>();
            session.setAttribute("cartItems", cartItems);
        }

        // Check if the book already exists in the cart
        for (CartItem cartItem : cartItems) {
            if (cartItem.getBook().getId() == bookId) {
                // If the book exists, ignore

                List<Book> books = bookService.getAll();
                model.addAttribute("books", books);

                return "redirect:./get-market";
            }
        }


        // If the book doesn't exist, add a new CartItem to the cart
        Book book = bookService.getById(bookId);
        CartItem cartItem = new CartItem();
        cartItem.setBook(book);
        cartItem.setQuantity(1);
        cartItems.add(cartItem);

        List<Book> books = bookService.getAll();
        model.addAttribute("get-market", books);

        return "redirect:./get-market";
    }





}
