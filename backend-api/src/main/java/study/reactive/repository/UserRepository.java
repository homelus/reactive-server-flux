package study.reactive.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.reactive.model.User;

/**
 * @author playjun
 * @since 2019 11 25
 */
@Component
@Slf4j
public class UserRepository {

    public User insert(User user) {
        log.info("## " + user.toString());
        user.setName(user.getName() + "_modified");
        user.setAge(user.getAge() + 10);
        return user;
    }

}
