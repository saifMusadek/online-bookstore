package bookstore.controller;

import bookstore.domain.Order;
import bookstore.domain.User;
import bookstore.services.OrderService;
import bookstore.services.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private HttpSession session;

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        Order existingOrder = orderService.getById(id);
        if (existingOrder != null) {
            order.setId(id);
            orderService.update(order);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        Order order = orderService.getById(id);
        if (order != null) {
            orderService.delete(order);
        }
    }


    //updating 22.5.23

    @RequestMapping(value = "/place-order", method = RequestMethod.POST)
    public String placeOrder(@ModelAttribute("totalprice") Double totalPrice,Model model){

        int orderId=orderService.getMaxId()+1;
        session.setAttribute("orderId", orderId);
        Integer userId = (Integer) session.getAttribute("userId");
        if(userId==null)
        {
            return "redirect:/login";
        }
        String orderStatus= "pending";
        LocalDate currentDate = LocalDate.now();
        Timestamp timestamp = Timestamp.valueOf(currentDate.atStartOfDay());
        Order order= new Order();
        order.setId(orderId);
        order.setUser(userService.getById(userId));
        order.setOrderDate(timestamp);
        order.setTotalPrice(totalPrice);
        order.setOrderStatus(orderStatus);
        orderService.save(order);

        return "redirect:../order-items/place-order1";
    }

    //updated 5.07 am
    @RequestMapping("/view-orders")
    public String showCustomerDashboard(Model model){

        int userId = (Integer) session.getAttribute("userId");
        List<Order> orders = orderService.getByUserId(userId);
        model.addAttribute("orderHistory", orders);

        return "customer/view-order";
    }


}
