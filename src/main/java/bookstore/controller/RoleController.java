package bookstore.controller;

import bookstore.domain.UserRole;
import bookstore.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userRoles")
public class RoleController {

    @Autowired
    private RoleService userRoleService;

    @PostMapping
    public void createUserRole(@RequestBody UserRole userRole) {
        userRoleService.save(userRole);
    }

    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAll();
    }

    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable Integer id) {
        return userRoleService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateUserRole(@PathVariable Integer id, @RequestBody UserRole userRole) {
        UserRole existingUserRole = userRoleService.getById(id);
        if (existingUserRole != null) {
            userRole.setId(id);
            userRoleService.update(userRole);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable Integer id) {
        UserRole userRole = userRoleService.getById(id);
        if (userRole != null) {
            userRoleService.delete(userRole);
        }
    }
}
