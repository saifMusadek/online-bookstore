package bookstore.controller;

import bookstore.domain.DeliveryHistory;
import bookstore.domain.DeliveryMan;
import bookstore.domain.Order;
import bookstore.services.DeliveryHistoryService;
import bookstore.services.DeliveryManService;
import bookstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class DeliveryManController {

    @Autowired
    private HttpSession session;

    @Autowired
    private OrderService orderService;
    @Autowired
    private DeliveryManService deliveryManService;
    @Autowired
    private DeliveryHistoryService deliveryHistoryService;

    @RequestMapping("/delivery/dashboard")
    public String showDashboard(){
        return "deliveryman/dashboard";
    }

    @RequestMapping("/delivery/orders")
    public String showOrders(Model model){


        int id = (Integer) session.getAttribute("delId");
        System.out.println(id);



       int orderId = deliveryManService.getOrderId(id);
        System.out.println(orderId);


        //Integer orderId = deliveryManService.getOrderId(id);
        if (orderId != 0) {
            model.addAttribute("orderId",orderId);
        } else {

            model.addAttribute("errorMessage", "No orders assigned to the delivery man.");
            return "deliveryman/orders";
        }

        return "deliveryman/orders";
    }


    @RequestMapping(value = "/delivery/orders",method = RequestMethod.POST)
    public String postOrders(Model model, @RequestParam("order") int orderId){

        // change the order status to picked up;
        boolean isUpdated2 = orderService.updateOrderStatus2(orderId);
        if (isUpdated2) {
            model.addAttribute("successMessage", "Order Picked Up");
        } else {
            model.addAttribute("errorMessage", "Failed to update");
        }

        return "deliveryman/orders";
    }


    @RequestMapping(value = "/delivery/orders-confirm", method = RequestMethod.GET)
    public String showCompleteDelievered(Model model){

        int id = (Integer) session.getAttribute("delId");
        System.out.println(id);



        int orderId = deliveryManService.getOrderId(id);
        System.out.println(orderId);


        //Integer orderId = deliveryManService.getOrderId(id);
        if (orderId != 0) {
            model.addAttribute("orderId",orderId);
        } else {

            model.addAttribute("errorMessage", "No orders assigned to the delivery man.");
            return "deliveryman/orders";
        }

        return "deliveryman/order-delievered";

    }


    @RequestMapping(value = "/delivery/orders-confirm",method = RequestMethod.POST)
    public String showComplete(Model model, @RequestParam("order") int orderId){

        // change the order status to picked up;

        //update order status to delivered
        boolean isUpdated2 = orderService.updateOrderStatus3(orderId);

        //update delivery man status to active, order_id = null;
        int id = (Integer) session.getAttribute("delId");
        System.out.println("control");

        boolean isUpdated3 = deliveryManService.updateStatusAndOrderId(id);

        //insert in order history // delId and orderId
        Order order = orderService.getById(orderId);
        DeliveryMan deliveryMan = deliveryManService.getById(id);


        DeliveryHistory deliveryHistory = new DeliveryHistory();
        //insert info in the orderHistory table
        if (isUpdated2 & isUpdated3) {
            deliveryHistory.setDeliveryMan(deliveryMan);
            deliveryHistory.setOrder(order);
            deliveryHistoryService.save(deliveryHistory);
            model.addAttribute("successMessage", "Order Delivered");

        } else {
            model.addAttribute("errorMessage", "Failed to update");
        }

        return "deliveryman/order-delievered";
    }


    @RequestMapping("/delivery/get-all")
    public String showAll(Model model){
        List<DeliveryHistory> deliveryHistories = deliveryHistoryService.getAll();
        model.addAttribute("deliveryHistoryList", deliveryHistories);
        return "deliveryman/show-all";
    }



}
