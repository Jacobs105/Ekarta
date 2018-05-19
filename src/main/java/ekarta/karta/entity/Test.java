package ekarta.karta.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "test")
public class Test {

    @Id
    private long test_id;
    private String title;
    private String text;
}
