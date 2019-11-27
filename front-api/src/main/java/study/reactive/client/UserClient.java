package study.reactive.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import study.reactive.domain.User;

/**
 * @author playjun
 * @since 2019 11 25
 */
@Component
@Slf4j
public class UserClient {

    private final WebClient webClient = WebClient.create("http://localhost:8892");

    public Mono<User> insert(Mono<User> user) {
        return webClient.post()
                .uri("/user")
                .body(user, User.class)
                .retrieve()
                .bodyToMono(User.class);
    }

    public Flux<User> getInternalUsers() {
        return webClient.get()
                .uri("/internal/users")
                .retrieve()
                .bodyToFlux(User.class);
    }

    public Flux<User> getExternalUsers() {
        return webClient.get()
                .uri("/external/users")
                .retrieve()
                .bodyToFlux(User.class);
    }

    public Flux<User> getSpecialUsers() {
        return webClient.get()
                .uri("/special/users")
                .retrieve()
                .bodyToFlux(User.class);
    }
}
