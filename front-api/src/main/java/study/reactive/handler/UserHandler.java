package study.reactive.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import study.reactive.client.UserClient;
import study.reactive.client.UserThirdyPartyClient;
import study.reactive.domain.User;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author playjun
 * @since 2019 11 26
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class UserHandler {

    private final UserClient userClient;
    private final UserThirdyPartyClient userThirdyPartyClient;

    public Mono<ServerResponse> insertUser(ServerRequest request) {
        return ok().body(userClient.insert(request.bodyToMono(User.class)), User.class);
    }

    public Mono<ServerResponse> compositeAllUsers(ServerRequest request) {
        Flux<User> internalUsers = userClient.getInternalUsers();
        Flux<User> externalUsers = userClient.getExternalUsers();
        Flux<User> specialUsers = userClient.getSpecialUsers();
        return ok().body(Flux.merge(internalUsers, externalUsers, specialUsers), User.class);
    }

    public Mono<ServerResponse> compositeSeoulAdults(ServerRequest request) {
        Flux<User> internalUsers = userClient.getInternalUsers();
        Flux<User> externalUsers = userClient.getExternalUsers();
        Flux<User> specialUsers = userClient.getSpecialUsers();

        Flux<User> adultsInSeoul = Flux.merge(internalUsers, externalUsers, specialUsers)
                .doOnNext(user -> log.info(user.toString()))
                .filter(User::isAdult)
                .filter(User::liveInSeoul)
                .transform(userThirdyPartyClient::update);
        return ok().body(adultsInSeoul, User.class);
    }

    public Mono<ServerResponse> orchestrateUser(ServerRequest request) {
        Mono<User> orchestration = userClient.insert(request.bodyToMono(User.class))
                .transform(userThirdyPartyClient::update);

        return ok().body(orchestration, User.class);
    }

}
