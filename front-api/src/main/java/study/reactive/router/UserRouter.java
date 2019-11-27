package study.reactive.router;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import study.reactive.handler.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author playjun
 * @since 2019 11 26
 */
@RequiredArgsConstructor
@Component
public class UserRouter {

    private final UserHandler userHandler;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route()
                .POST("/user", accept(APPLICATION_JSON), userHandler::insertUser)
                .GET("/users", userHandler::compositeAllUsers)
                .build();

    }

}
