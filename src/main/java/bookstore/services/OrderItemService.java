package bookstore.services;

import bookstore.domain.OrderItem;
import bookstore.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void save(OrderItem orderItem) {
        if (orderItem != null) {
            orderItemRepository.save(orderItem);
        }
    }

    public void delete(OrderItem orderItem) {
        if (orderItem != null) {
            orderItemRepository.delete(orderItem);
        }
    }

    public List<OrderItem> getAll() {
        return orderItemRepository.getAll();
    }

    public OrderItem getById(Integer id) {
        if (id != null) {
            return orderItemRepository.getById(id);
        }
        return null;
    }

    public boolean update(OrderItem orderItem) {
        if (orderItem != null) {
            return orderItemRepository.update(orderItem);
        }
        return false;
    }

    public List<OrderItem> getByOrderId(Integer id) {
        if (id != null) {
            return orderItemRepository.getByOrderId(id);
        }
        return null;
    }
}
