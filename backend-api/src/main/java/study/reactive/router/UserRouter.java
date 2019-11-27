package study.reactive.router;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import study.reactive.handler.UserHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

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
        return route(POST("/user"), userHandler::insertUser)
                .andRoute(GET("/internal/users"), userHandler::internalUsers)
                .andRoute(GET("/external/users"), userHandler::externalUsers)
                .andRoute(GET("/special/users"), userHandler::specialUsers);
    }

}
