package study.reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author playjun
 * @since 2019 11 27
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String location;
    private int age;

    public boolean isAdult() {
        return age > 19;
    }

    public boolean liveInSeoul() {
        return "seoul".equalsIgnoreCase(this.location);
    }
}
