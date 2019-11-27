package study.reactive.thirdpartyapi.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author playjun
 * @since 2019 11 25
 */
@Data
@ToString
public class User {

    private String name;
    private String location;
    private int age;

}
