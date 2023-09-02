package bookstore.services;

import bookstore.domain.UserRole;
import bookstore.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void save(UserRole role) {
        if (role != null) {
            roleRepository.save(role);
        }
    }

    public void delete(UserRole role) {
        if (role != null) {
            roleRepository.delete(role);
        }
    }

    public List<UserRole> getAll() {
        return roleRepository.getAll();
    }

    public UserRole getById(Integer id) {
        if (id != null) {
            return roleRepository.getById(id);
        }
        return null;
    }

    public boolean update(UserRole role) {
        if (role != null) {
            return roleRepository.update(role);
        }
        return false;
    }
}
