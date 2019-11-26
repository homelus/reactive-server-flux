package study.reactive.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
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

}
