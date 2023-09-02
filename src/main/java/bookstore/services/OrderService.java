package bookstore.services;

import bookstore.domain.Order;
import bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void save(Order order) {
        if (order != null) {
            orderRepository.save(order);
        }
    }

    public void delete(Order order) {
        if (order != null) {
            orderRepository.delete(order);
        }
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Order getById(Integer id) {
        if (id != null) {
            return orderRepository.getById(id);
        }
        return null;
    }



    public List<Order>getAllPendingOrders(){
        return orderRepository.getAllPendingOrders();
    }



    public boolean update(Order order) {
        if (order != null) {
            return orderRepository.update(order);
        }
        return false;
    }

    public boolean updateOrderStatus(int id){

            return orderRepository.updateOrderStatus(id);

    }
    public boolean updateOrderStatus2(int id){
        return orderRepository.updateOrderStatus2(id);
    }

    public boolean updateOrderStatus3(int id){
        return orderRepository.updateOrderStatus3(id);
    }

    public int getMaxId()
    {
        return orderRepository.getMaxId();
    }

    public List<Order> getByUserId(Integer id) {
        if (id != null) {
            return orderRepository.getByUserId(id);
        }
        return null;
    }

}
