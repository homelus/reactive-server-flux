package study.reactive.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import study.reactive.domain.User;
import study.reactive.service.UserService;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author playjun
 * @since 2019 11 26
 */
@Component
@RequiredArgsConstructor
public class UserHandler {

    private final UserService userService;

    public Mono<ServerResponse> insertUser(ServerRequest request) {
        return request.bodyToMono(User.class)
            .flatMap(userService::insert)
            .transform(usr -> ok().body(usr, User.class));
    }

    public Mono<ServerResponse> internalUsers(ServerRequest request) {
        return ok().body(Flux.fromIterable(userService.getInternalUsers()), User.class);
    }

    public Mono<ServerResponse> externalUsers(ServerRequest request) {
        return ok().body(Flux.fromIterable(userService.getExternalUsers()), User.class);
    }

    public Mono<ServerResponse> specialUsers(ServerRequest request) {
        return ok().body(Flux.fromIterable(userService.getSpecialUsers()), User.class);
    }

}
