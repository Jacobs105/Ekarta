package ekarta.karta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class LoginController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){


        return  "login";
    }


    @RequestMapping(value = "/login-error")
    public String loginerror(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }
}
