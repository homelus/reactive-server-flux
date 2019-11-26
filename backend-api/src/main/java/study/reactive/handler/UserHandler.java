package study.reactive.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import study.reactive.model.User;
import study.reactive.repository.UserRepository;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author playjun
 * @since 2019 11 26
 */
@Component
@RequiredArgsConstructor
public class UserHandler {

    private final UserRepository userRepository;

    public Mono<ServerResponse> insertUser(ServerRequest request) {
        return request.bodyToMono(User.class)
            .doOnNext(userRepository::insert)
            .flatMap(usr -> ok().body(Mono.just(usr), User.class));
    }

}
