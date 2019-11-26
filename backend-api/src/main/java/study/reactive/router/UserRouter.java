package study.reactive.router;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import study.reactive.handler.UserHandler;
import study.reactive.model.User;
import study.reactive.repository.UserRepository;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author playjun
 * @since 2019 11 26
 */
@Component
@RequiredArgsConstructor
public class UserRouter {

    private final UserHandler userHandler;

    @Bean
    RouterFunction<ServerResponse> router() {
        return route(POST("/user"), userHandler::insertUser);
    }

}
