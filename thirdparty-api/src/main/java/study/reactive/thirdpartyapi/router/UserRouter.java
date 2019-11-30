package study.reactive.thirdpartyapi.router;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import study.reactive.thirdpartyapi.handler.UserHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author playjun
 * @since 2019 11 27
 */
@RequiredArgsConstructor
@Component
public class UserRouter {

    private final UserHandler userHandler;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route()
                .POST("/user", userHandler::updateUser)
                .POST("/users", userHandler::updateUsers)
                .build();
    }


}
