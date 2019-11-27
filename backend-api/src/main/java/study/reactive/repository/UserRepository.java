package study.reactive.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.reactive.model.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

/**
 * @author playjun
 * @since 2019 11 25
 */
@Component
@Slf4j
public class UserRepository {

    public User insert(User user) {
        log.info("## " + user.toString());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ignore) {
        }
        user.setName(user.getName() + "_modified");
        user.setAge(user.getAge() + 10);
        return user;
    }

    public List<User> getInternalUsers() {
        log.info("getInternalUsers called");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ignore) {
        }
        return asList(new User("jun", 11), new User("min", 10));
    }

    public List<User> getExternalUsers() {
        log.info("getExternalUsers called");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException ignore) {
        }
        return asList(new User("hong", 21), new User("song", 30));
    }

    public List<User> getSpecialUsers() {
        log.info("getSpecialUsers called");
        try {
            TimeUnit.SECONDS.sleep(9);
        } catch (InterruptedException ignore) {
        }
        return asList(new User("james", 17), new User("chris", 14));
    }

}
