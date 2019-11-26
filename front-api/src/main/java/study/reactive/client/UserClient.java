package study.reactive.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import study.reactive.model.User;

/**
 * @author playjun
 * @since 2019 11 25
 */
@Component
@Slf4j
public class UserClient {

    public Mono<User> insert(Mono<User> user) {
        return WebClient.create("http://localhost:8892").post()
                .uri("/user")
                .body(user, User.class)
                .retrieve()
                .bodyToMono(User.class);
    }
}
