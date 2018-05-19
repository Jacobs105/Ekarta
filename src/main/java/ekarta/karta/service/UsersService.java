package ekarta.karta.service;

import ekarta.karta.entity.User;
import ekarta.karta.service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UsersService {
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    @ModelAttribute("userList")
    public List<User> findAll(){ return (ArrayList<User>)userRepository.findAll();}

    public void registerNewUser(@Valid User user){ userRepository.save(user);}
}
