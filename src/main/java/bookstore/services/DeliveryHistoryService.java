package bookstore.services;

import bookstore.domain.DeliveryHistory;
import bookstore.repository.DeliveryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeliveryHistoryService {

    @Autowired
    private DeliveryHistoryRepository deliveryHistoryRepository;

    public void save(DeliveryHistory deliveryHistory) {
        if (deliveryHistory != null) {
            deliveryHistoryRepository.save(deliveryHistory);
        }
    }

    public void delete(DeliveryHistory deliveryHistory) {
        if (deliveryHistory != null) {
            deliveryHistoryRepository.delete(deliveryHistory);
        }
    }

    public List<DeliveryHistory> getAll() {
        return deliveryHistoryRepository.getAll();
    }

    public DeliveryHistory getById(Integer id) {
        if (id != null) {
            return deliveryHistoryRepository.getById(id);
        }
        return null;
    }

    public List<DeliveryHistory> getByDeliveryManId(Integer deliveryManId) {
        if (deliveryManId != null) {
            return deliveryHistoryRepository.getByDeliveryManId(deliveryManId);
        }
        return null;
    }

    public boolean update(DeliveryHistory deliveryHistory) {
        if (deliveryHistory != null) {
            return deliveryHistoryRepository.update(deliveryHistory);
        }
        return false;
    }
}
