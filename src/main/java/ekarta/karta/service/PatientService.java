package ekarta.karta.service;

import ekarta.karta.entity.Patient;
import ekarta.karta.service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @ModelAttribute("patientList")
    public List<Patient> findAll(){
        return (ArrayList<Patient>) patientRepository.findAll();
    }

    public void registerNewPatient(@Valid Patient patient){
        patientRepository.save(patient);
    }


    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
