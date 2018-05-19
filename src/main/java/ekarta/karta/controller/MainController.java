package ekarta.karta.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import ekarta.karta.entity.Test;
import ekarta.karta.entity.User;
import ekarta.karta.service.TestService;
import ekarta.karta.service.UsersService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UsersService userService;
    @Autowired
    private TestService testService;

    @RequestMapping(value = {"/","/home"})
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){


        return  "login";
    }


    @RequestMapping(value = "/login-error")
    public String loginerror(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }
    @RequestMapping(value = "/usersList",method = RequestMethod.GET)
    public ModelAndView showList(){
        ModelAndView mv = new ModelAndView("usersList");
        List<User> usersList = userService.findAll();
        mv.addObject("userList",usersList);
        return mv;
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(Local local){
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("userRegister",new User());
        return mv;
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("test");
        List<Test> testList = testService.findAll();
        mv.addObject("testList",testList);
        return mv;
    }


}
