package ekarta.karta.controller;

import ekarta.karta.entity.User;
import ekarta.karta.service.PatientService;
import ekarta.karta.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/my-patientList",method = RequestMethod.GET)
    public ModelAndView myPatientList(Principal principal){

        ModelAndView mv = new ModelAndView("myPatients");
        Optional<User> user = usersService.findUserByEmail(principal.getName());
        if(user.isPresent()){
            mv.addObject("patientList",user.get().getPatients());
        }
        return mv;
    }


}
