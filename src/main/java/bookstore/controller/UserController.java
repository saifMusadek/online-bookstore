package bookstore.controller;

import bookstore.domain.User;
import bookstore.domain.UserRole;
import bookstore.services.DeliveryManService;
import bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;

    @Autowired
    private DeliveryManService deliveryManService;

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String getOrderPage(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("userList", users);
        return "redirect:/market/get-market";
    }




    //Signup'
    //validation.............................
    @RequestMapping(value = "/signup", method=RequestMethod.GET)
    public String showRegister(Model model) {
        model.addAttribute("user",new User());
        return "entry/signup";
    }
    //validation.............................
    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String handleRegister(@Valid @ModelAttribute("user") User user,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Validation failed, return to the signup form with error messages
            return "entry/signup";
        }
        user.setRole(2);
        this.userService.save(user);
        return "redirect:/login";
    }

    //login
    @RequestMapping("/login")
    public String showLoginPage(){
        return "entry/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateLoginPage(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        if (username == null) {
            model.addAttribute("error", "Username is required");
            return "entry/login";
        }

        String storedPassword = userService.getPasswordByUsername(username);
        System.out.println(username);

        if (username.startsWith("del_")) {
            String storedPassword2 = deliveryManService.getPasswordByUsername(username);
            if(storedPassword2!=null && storedPassword2.equals(password)){
                int id = deliveryManService.getIdByUserName(username);
                session.setAttribute("delId", id);
                return "redirect:delivery/dashboard ";
            }

        }


        if (storedPassword != null && storedPassword.equals(password)) {
            if(username.equals("admin")){
                return "redirect:admin/dashboard";
            }

            int id = userService.getIdByUserName(username);
            session.setAttribute("userId", id);
            return "redirect:customer/dashboard";
        }else {
            model.addAttribute("error", "Invalid username or password");
            return "entry/login";
        }

    }

    @RequestMapping("/customer/dashboard")
    public String showCustomerDashboard(){

//        session.setAttribute("userId", 17);
//        int userId = (Integer) session.getAttribute("userId");
//        int cartId=cartService.getByUserId(userId);
//        System.out.println(cartId);
//
//        if(cartService.getByUserId(userId)==0)
//        {
//            System.out.println("not found");
//            Cart cart=new Cart();
//            cart.setUser( userService.getById(userId));
//            cartService.save(cart);
//        }
//        else
//        {
//            System.out.println("found");
//            List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
//            if (cartItems != null) {
//                // Iterate over the cart items and remove the one with the matching book ID
//                Iterator<CartItem> iterator = cartItems.iterator();
//                while (iterator.hasNext()) {
//                    CartItem cartItem = iterator.next();
//                    cartItem.setCart(cartService.getById(cartId));
//                    cartItemService.save(cartItem);
//                }
//                // Update the session with the modified cart items
//                cartItems.clear();
//                session.setAttribute("cartItems", cartItems);
//            }
//        }




        return "customer/dashboard";
    }





    @RequestMapping(value="delete/{id}", method=RequestMethod.GET)
    public String deleteItem(@PathVariable Integer id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:entry/success";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("customer") User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "customer/edit";
        }
        userService.update(user);
        return "redirect:/customers/list";
    }


    @RequestMapping("/")
    public String showIndex(){
        return"redirect:/market/get-market";
    }
    @RequestMapping("/customer/profile")
    public String showCustomerProfile(Model model){
        int id=(Integer)session.getAttribute("userId");

        List<User> userDetails = new ArrayList<>();
        User user = userService.getById(id);
        userDetails.add(user);

        model.addAttribute("userDetails",userDetails);

        return "customer/profile";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession s){
        s.invalidate();
        return "redirect:/login";
    }

}
