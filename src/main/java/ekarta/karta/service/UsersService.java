package ekarta.karta.service;

import ekarta.karta.entity.Role;
import ekarta.karta.entity.User;
import ekarta.karta.service.repository.RoleRepository;
import ekarta.karta.service.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService {
    private  UserRepository userRepository;
    private RoleRepository roleRepository;


    public UsersService(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository=userRepository;
        this.roleRepository = roleRepository;
    }
    @ModelAttribute("userList")
    public List<User> findAll(){ return (ArrayList<User>)userRepository.findAll();}

    public void registerNewUser(@Valid User user){
        Role r = roleRepository.findRoleByRoleName("USER");
        user.setRole(r);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String bCryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(bCryptedPassword);
        userRepository.save(user);
    }

    public boolean isEmailTaken(String email) {
        Optional<User> user = userRepository.findUserByEmailContainingIgnoreCase(email);
        System.out.println("Mail jest zajęty");

        return user.isPresent();
    }

    public void deleteUser(String email){
        userRepository.deleteByEmail(email);
    }
}
