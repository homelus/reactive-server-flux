package study.reactive.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author playjun
 * @since 2019 11 27
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String location;
    private int age;
    private String type;

    public boolean isAdult() {
        return age > 19;
    }

    public boolean liveInSeoul() {
        return "seoul".equalsIgnoreCase(this.location);
    }
}
