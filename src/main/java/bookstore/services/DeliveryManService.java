package bookstore.services;

import bookstore.domain.DeliveryMan;
import bookstore.repository.DeliveryManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeliveryManService {

    @Autowired
    private DeliveryManRepository deliveryManRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(DeliveryMan deliveryMan) {
        if (deliveryMan != null) {
            deliveryManRepository.save(deliveryMan);
        }
    }

    public void delete(DeliveryMan deliveryMan) {
        if (deliveryMan != null) {
            deliveryManRepository.delete(deliveryMan);
        }
    }

    public List<DeliveryMan> getAll() {
        return deliveryManRepository.getAll();
    }

    public DeliveryMan getById(Integer id) {
        if (id != null) {
            return deliveryManRepository.getById(id);
        }
        return null;
    }

    public int getIdByUserName(String username){
        return deliveryManRepository.getIdByUserName(username);
    }

    public Integer getOrderId(int id){
        return deliveryManRepository.getOrderId(id);
    }

    public boolean updateStatusAndOrderId(int id_del){
        return deliveryManRepository.updateStatusAndOrderId(id_del);
    }


    public DeliveryMan getByUsername(String username) {
        return deliveryManRepository.getByUsername(username);
    }

    public boolean update(DeliveryMan deliveryMan) {
        deliveryMan.setPassword(passwordEncoder.encode(deliveryMan.getPassword()));
        return deliveryManRepository.update(deliveryMan);
    }

    public String getPasswordByUsername(String username) {
        return deliveryManRepository.getPasswordByUsername(username);
    }

    public List<DeliveryMan>getAllActiveDeliveryMan(){
        return deliveryManRepository.getAllActiveDeliveryMan();
    }

    public boolean updateDeliveryManStatusOrderStatus(int id, int orderId){
        return deliveryManRepository.updateDeliveryManStatusOrderStatus(id,orderId);
    }

}
