package study.reactive.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import study.reactive.client.UserClient;
import study.reactive.model.User;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author playjun
 * @since 2019 11 26
 */
@RequiredArgsConstructor
@Service
public class UserHandler {

    private final UserClient userClient;

    public Mono<ServerResponse> insertUser(ServerRequest request) {
        return ok().body(userClient.insert(request.bodyToMono(User.class)), User.class);
    }

    public Mono<ServerResponse> compositeAllUsers(ServerRequest request) {
        Flux<User> internalUsers = userClient.getInternalUsers();
        Flux<User> externalUsers = userClient.getExternalUsers();
        Flux<User> specialUsers = userClient.getSpecialUsers();
        return ok().body(Flux.merge(internalUsers, externalUsers, specialUsers), User.class);
    }

}
