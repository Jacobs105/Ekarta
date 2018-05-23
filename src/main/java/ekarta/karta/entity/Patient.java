package ekarta.karta.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "patient", schema = "ekarta")
public class Patient  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pat_seq")
    @SequenceGenerator(name = "pat_seq",schema = "ekarta", sequenceName = "patient_id_seq")
    @Column(name = "patient_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "pesel")
    @Pattern(regexp = "[0-9]{11}")
    private String pesel;

    @Column(name = "address")
    private String address;

    @Column(name = "zpicode")
    @Pattern(regexp ="[0-9]{2}(|-)?[0-9]{3}")
    private String zip_code;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "patients")
    private List<User> users = new ArrayList<>();

}
