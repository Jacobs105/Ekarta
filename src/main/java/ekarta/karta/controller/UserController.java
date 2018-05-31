package ekarta.karta.controller;

import ekarta.karta.entity.Patient;
import ekarta.karta.entity.User;
import ekarta.karta.service.PatientService;
import ekarta.karta.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/my-patientList",method = RequestMethod.GET)
    public ModelAndView myPatientList(Principal principal){

        ModelAndView mv = new ModelAndView("myPatients");
        Optional<User> user = usersService.findUserByEmail(principal.getName());
        if(user.isPresent()){
            mv.addObject("patientList",user.get().getPatients());
        }
        return mv;
    }

    @RequestMapping(value = "/addPatient",method = RequestMethod.GET)
    public ModelAndView addPatient(Locale locale){
        ModelAndView mv = new ModelAndView("addPatient");//TODO Do poprawy

        mv.addObject("patientInfo",new Patient());
        return mv;
    }


    @RequestMapping(value = "/addPatient",method = RequestMethod.POST)
    public ModelAndView addPatient(@ModelAttribute("patientInfo")@Valid Patient patient,
                                   Principal principal,Locale locale){
        ModelAndView mv = new ModelAndView("addPatient");
        Optional<User> user = usersService.findUserByEmail(principal.getName());



        if (user.isPresent()){

            patient.setUser(user.get());

            patientService.registerNewPatient(patient);
            mv.addObject("success","success");
            mv.setViewName("redirect:/user/my-patientList");
        }else {
            mv.addObject("failure","failure");

        }
        return mv;

    }
    @RequestMapping(value = "/patientDelete/{id}",method = RequestMethod.GET)
    public String deletePatient(@PathVariable int id){

        patientService.deletePatient(id);

        return "redirect:/user/my-patientList";
    }




}
