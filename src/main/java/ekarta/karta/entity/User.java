package ekarta.karta.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "doctors")
public class User implements Serializable {//TODO Brak relacji z users

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "role_id")//FK
    private long role;
//    private Date birthDay;
//    @Pattern(regexp = "[0-9]{11}")
//    private String pesel;
//    private String address;
//    private String city;
//    private String state;
//    @Pattern(regexp ="[0-9]{2}(|-)?[0-9]{3}")
//    private String zipCode;

}
