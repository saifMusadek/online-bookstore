package bookstore.controller;

import bookstore.domain.*;
import bookstore.services.BookService;
import bookstore.services.OrderItemService;
import bookstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BookService bookService;

    @Autowired
    private HttpSession session;

    @PostMapping
    public void createOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.save(orderItem);
    }

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAll();
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItemById(@PathVariable Integer id) {
        return orderItemService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateOrderItem(@PathVariable Integer id, @RequestBody OrderItem orderItem) {
        OrderItem existingOrderItem = orderItemService.getById(id);
        if (existingOrderItem != null) {
            orderItem.setId(id);
            orderItemService.update(orderItem);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Integer id) {
        OrderItem orderItem = orderItemService.getById(id);
        if (orderItem != null) {
            orderItemService.delete(orderItem);
        }
    }


    ////updating..

    @RequestMapping(value = "/place-order1")
    public String confirmPlaceOrder( Model model){
        OrderItem orderItem= new OrderItem();
        int orderId = (Integer) session.getAttribute("orderId");

        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItems != null) {
            // Iterate over the cart items and remove the one with the matching book ID
            Iterator<CartItem> iterator = cartItems.iterator();
            while (iterator.hasNext()) {
                CartItem cartItem = iterator.next();

                orderItem.setOrder(orderService.getById(orderId));
                Book book=cartItem.getBook();


                int bookLeft=book.getQuantity();
                int bookOrdered= cartItem.getQuantity();

                book.setQuantity(bookLeft-bookOrdered);
//                bookService.save(book);
                bookService.updateBook(book);

                orderItem.setQuantity(bookOrdered);
                orderItem.setBook(cartItem.getBook());
                orderItemService.save(orderItem);
            }
            // Update the session with the modified cart items
            cartItems.clear();
            session.setAttribute("cartItems", cartItems);
        }







        return "redirect:../customer/dashboard";
    }

    @RequestMapping(value="order-details/{id}", method=RequestMethod.GET)
    public String viewOrderItems(@PathVariable Integer id, Model model) {
//        OrderItem order=orderItemService.getByOrderId(id);
//        session.setAttribute("orderDetails",order);
        System.out.println(orderItemService.getByOrderId(id));
        List<OrderItem> orderItems = orderItemService.getByOrderId(id);

        model.addAttribute("orderDetails", orderItems);
        return "customer/order-details";
    }
}
