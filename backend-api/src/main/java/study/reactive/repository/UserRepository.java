package study.reactive.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import study.reactive.domain.User;

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

    public Mono<User> insert(User user) {
        log.info("## " + user.toString());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ignore) {
        }
        user.setName(user.getName() + "_modified");
        user.setAge(user.getAge() + 10);
        return Mono.just(user);
    }

    public List<User> getInternalUsers() {
        log.info("getInternalUsers called");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ignore) {
        }
        return asList(new User("jun", "seoul", 11), new User("min", "busan", 10));
    }

    public List<User> getExternalUsers() {
        log.info("getExternalUsers called");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ignore) {
        }
        return asList(new User("hong","seoul", 21), new User("song", "seoul", 30));
    }

    public List<User> getSpecialUsers() {
        log.info("getSpecialUsers called");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ignore) {
        }
        return asList(new User("james", "jeju", 17), new User("chris","seoul", 14));
    }

}
