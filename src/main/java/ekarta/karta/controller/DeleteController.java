package ekarta.karta.controller;

import ekarta.karta.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class DeleteController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/userDelete/{email}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable String email){
        usersService.deleteUser(email);

        return "deleteSuccess";
    }


    @RequestMapping(value = "/userDelete/{email}",method = RequestMethod.GET)
    public String deleteUser(@PathVariable String email, Locale locale){


        return "deleteSuccess";
    }

}
