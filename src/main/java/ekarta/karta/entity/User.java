package ekarta.karta.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctors",schema = "ekarta")//Rozwiązanie problemu relacji
public class User implements Serializable {//TODO Brak relacji z users

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
   @SequenceGenerator(name = "user_seq" ,schema = "ekarta",sequenceName = "doctor_id_seq",
           initialValue = 1,allocationSize = 1)
    @Column(name="user_id")
    private long id;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_pwd")
    private String password;
    @Column(name = "user_firstname")
    private String firstName;
    @Column(name = "user_lastname")
    private String lastName;
    @Column(name = "user_speciality")
    private String speciality;
    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Patient> patients;

//    private Date birthDay;
//    @Pattern(regexp = "[0-9]{11}")
//    private String pesel;
//    private String address;
//    private String city;
//    private String state;
//    @Pattern(regexp ="[0-9]{2}(|-)?[0-9]{3}")
//    private String zipCode;

}
