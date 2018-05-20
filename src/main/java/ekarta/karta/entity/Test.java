package ekarta.karta.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "test", schema = "ekarta")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "test_seq")
    @SequenceGenerator(name = "test_seq",schema = "ekarta")
    private long test_id;
    private String title;
    private String text;
}
