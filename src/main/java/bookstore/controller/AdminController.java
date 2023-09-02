package bookstore.controller;

import bookstore.domain.DeliveryMan;
import bookstore.domain.Order;
import bookstore.domain.User;
import bookstore.domain.UserRole;
import bookstore.services.DeliveryManService;
import bookstore.services.OrderService;
import bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class AdminController {

    static final Logger logger = Logger.getLogger(AdminController.class.getName());
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DeliveryManService deliveryManService;


//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
    @RequestMapping("/dashboard")
    public String showDashboard(){
        return "admin/admin_dashboard";

    }

    @RequestMapping("/show-all-users")
    public String showAllUsers(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("userList", users);
        System.out.println(users);
        return "admin/user/show_all_users";
    }

    @RequestMapping("/edit-users")
    public String showEditUsers(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("userList", users);
        System.out.println(users);
        return "admin/user/edit_specific_user";
    }

    @RequestMapping(value = "/search-users-edit", method = RequestMethod.POST)
    public String getEditInfoById(@RequestParam("id") Integer id, Model model, RedirectAttributes redirectAttributes){
        User user = userService.getById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "admin/user/edit_specific_user";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "User not found");
            return "redirect:/admin/edit-users";
        }
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute User user, Model model, @RequestParam("role_id") Integer role_id) {
        user.setRole(role_id);
        boolean isUpdated = userService.updateUser(user);
        if (isUpdated) {
            model.addAttribute("successMessage", "User updated successfully");
        } else {
            model.addAttribute("errorMessage", "Failed to update user");
        }
        // Redirect to the appropriate page after updating
        return "redirect:/admin/show-all-users";
    }

    @RequestMapping("/show-delete")
    public String showDelete(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("userList", users);
        System.out.println(users);

        return "admin/user/delete_user";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteItem(@PathVariable Integer id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/admin/show-all-users";
    }




    //Deliveries

    //show pending orders


    @RequestMapping(value="/show-pending-orders", method=RequestMethod.GET)
    public String showPendingOrders(Model model){
        //select * from orders where status = pending;
        List<Order> orders = orderService.getAllPendingOrders();
        model.addAttribute("orderList", orders);

        return "admin/deliveries/pending-orders";
    }
    //show all delivery man

    @RequestMapping(value="/show-delivery-man", method=RequestMethod.GET)
    public String showAllDeliveryMan(Model model){
        List<DeliveryMan> deliveryMEN = deliveryManService.getAll();
        model.addAttribute("deliverymanList", deliveryMEN);
        return "admin/deliveries/show-delivery-man";
    }

    //assign order to delivery man and change delivery man status to busy and order status to processing

    @RequestMapping(value = "/assign-delivery-man", method=RequestMethod.GET)
    public String showAvailableDeliveryMan(Model model){

        // Select * from delivery man where status = active
        // select * from order where status = pending
        List<DeliveryMan> deliveryMEN = deliveryManService.getAllActiveDeliveryMan();
        List<Order> orders = orderService.getAllPendingOrders();
        model.addAttribute("deliverymanList", deliveryMEN);
        model.addAttribute("orderList", orders);

        return "admin/deliveries/assign-deliveries";
    }

    @RequestMapping(value = "/assigned-delivery-man", method=RequestMethod.POST)
    public String assignDeliveries(Model model,@RequestParam("deliveryMan") int deliveryManId, @RequestParam("order") int orderId ){

        // get the delivery man id and order id from the view


        // update Delivery man: status = busy, orderStatus = pending, order_id = order id from view
        boolean isUpdated = deliveryManService.updateDeliveryManStatusOrderStatus(deliveryManId,orderId);
        // update Order: order_status to processing
        boolean isUpdated2 = orderService.updateOrderStatus(orderId);
        if (isUpdated && isUpdated2) {
            model.addAttribute("successMessage", "updated successfully");
        } else {
            model.addAttribute("errorMessage", "Failed to update");
        }

        return "admin/deliveries/assign-deliveries";
    }













    //UserName = Del_Kashim


}

