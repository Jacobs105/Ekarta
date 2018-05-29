package ekarta.karta.controller;

import ekarta.karta.entity.User;
import ekarta.karta.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class RegisterController {


    @Autowired
    private UsersService usersService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(Locale locale){
        ModelAndView mv = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){
            if(locale.getLanguage().equals("en")){
                mv.setViewName("redirect:/");
            }else{
                mv.setViewName("redirect:/");
            }
        }
        mv.addObject("userRegister",new User());
        return mv;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("userRegister")@Valid User user,
                                 BindingResult result,Locale locale){
        ModelAndView mv = new ModelAndView("register");

        if(result.hasErrors()){
            mv.addObject("failure","failure");
            return mv;
        }
        if (usersService.isEmailTaken(user.getEmail())){
            FieldError emailTakenError = new FieldError("userRegister",
                    "email",messageSource.getMessage("email.taken",null,locale));
            result.addError(emailTakenError);
            mv.addObject("failure","failure");
            return mv;
        }

        usersService.registerNewUser(user);
        mv.addObject("success","success");
        System.out.println("ZAPISANE");

        return mv;
    }
}
