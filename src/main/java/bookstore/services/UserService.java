package bookstore.services;

import bookstore.domain.User;
import bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    //private Logger logger = Logger.getLogger(UserService.class.getName());


    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    public UserService() {


    }
    public void save(User user) {
        if(user!=null) {
            userRepository.save(user);
        }
    }



    public void delete(User user) {
        if(user!=null) {
            userRepository.delete(user);
        }
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getById(Integer id) {
        if(id!=null) {
            return userRepository.getById(id);
        }
        return null;
    }

    public int getIdByUserName(String username){
        return userRepository.getIdByUserName(username);
    }



    public User getUsername(String username) {
        return userRepository.getUserName(username);
    }


    public boolean update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.update(user);
    }

    public boolean updateUser(User user) {
        return userRepository.update(user);
    }


    public String getPasswordByUsername(String username) {
        return userRepository.getPasswordByUsername(username);
    }
    public User get(String username) { return userRepository.get(username); }


    public String findRole(String username){
        return(userRepository.findRole(username));
    }


}
