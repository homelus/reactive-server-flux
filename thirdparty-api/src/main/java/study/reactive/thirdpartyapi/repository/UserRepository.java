package study.reactive.thirdpartyapi.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import study.reactive.thirdpartyapi.domain.User;

import java.util.concurrent.TimeUnit;

/**
 * @author playjun
 * @since 2019 11 27
 */
@Component
@Slf4j
public class UserRepository {

    public Mono<User> updateUser(Mono<User> user) {
        return user.flatMap(this::update);
    }

    public Flux<User> updateUsers(Flux<User> users) {
        return users.flatMap(this::update);
    }

    private Mono<User> update(User user) {
        log.info("update user");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ignored) {
        }
        user.setAge(user.getAge() - 1);
        user.setName("third_" + user.getName());
        return Mono.just(user);
    }



}
