package study.reactive.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import study.reactive.domain.User;

/**
 * @author playjun
 * @since 2019 11 27
 */
@Component
public class UserThirdyPartyClient {

    private final WebClient webClient = WebClient.create("http://localhost:8893");

    public Mono<User> update(Mono<User> user) {
        return webClient.post()
                .uri("/user")
                .body(user, User.class)
                .retrieve()
                .bodyToMono(User.class);
    }

    public Flux<User> update(Flux<User> users) {
        return webClient.post()
                .uri("/users")
                .body(users, User.class)
                .retrieve()
                .bodyToFlux(User.class);
    }

}
