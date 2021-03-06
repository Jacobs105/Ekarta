package ekarta.karta.controller;

import ekarta.karta.entity.User;
import ekarta.karta.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private UsersService userService;

    @RequestMapping(value = "/usersList",method = RequestMethod.GET)
    public ModelAndView showList(){
        ModelAndView mv = new ModelAndView("usersList");
        List<User> usersList = userService.findAll();
        mv.addObject("userList",usersList);
        return mv;
    }
    @RequestMapping(value = "/userDelete/{email}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String email){
        userService.deleteUser(email);

        return "redirect:/admin/usersList";
    }

}
