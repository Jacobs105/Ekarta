package ekarta.karta.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@Entity
@Table(name = "role",schema = "ekarta")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;
    @Column(name = "role_name")
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "role" )
    @Transient

    private Set<User> users = new TreeSet<>();

}
