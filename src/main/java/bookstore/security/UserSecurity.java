//package bookstore.security;
//
//import bookstore.domain.User;
//import bookstore.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class UserSecurity implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.get(username);
//        if (user == null) {
//            return null;
//        } else {
//            String role = userService.findRole(username); // Fetch the role using userService.findRole()
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(role));
//            System.out.println(authorities);
//
//            return new org.springframework.security.core.userdetails.User(
//                    user.getUsername(),
//                    passwordEncoder.encode(user.getPassword()),
//                    authorities
//            );
//        }
//    }
//}