package study.reactive.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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

    public Mono<User> insert(User user) {

        log.info(user.toString());

        WebClient webClient = WebClient.builder()
                .baseUrl("localhost:8892").build();

        return webClient.method(HttpMethod.POST)
                .uri("/user")
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(User.class)
                .log();
    }
}
