package ekarta.karta.controller;

import ekarta.karta.entity.User;
import ekarta.karta.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class MainRestController {
    @Autowired
    private UsersService usersService;

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("userRegister")@Valid User user){
        ModelAndView mv = new ModelAndView("registerSuccess");
        usersService.registerNewUser(user);
        System.out.println("ZAPISANE");

        return mv;
    }
}
