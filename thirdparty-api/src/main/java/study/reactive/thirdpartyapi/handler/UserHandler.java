package study.reactive.thirdpartyapi.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import study.reactive.thirdpartyapi.domain.User;
import study.reactive.thirdpartyapi.repository.UserRepository;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author playjun
 * @since 2019 11 27
 */
@RequiredArgsConstructor
@Service
public class UserHandler {

    private final UserRepository userRepository;

    public Mono<ServerResponse> updateUser(ServerRequest request) {
        return ok().body(userRepository.updateUser(request.bodyToMono(User.class)), User.class);
    }

    public Mono<ServerResponse> updateUsers(ServerRequest request) {
        return ok().body(userRepository.updateUsers(request.bodyToFlux(User.class)), User.class);
    }
}
