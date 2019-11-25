package study.reactive.client;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import study.reactive.model.User;

/**
 * @author playjun
 * @since 2019 11 25
 */
@Component
public class UserClient {

    public void insert(User user) {
        WebClient webClient = WebClient.builder()
                .baseUrl("localhost:8892").build();

        webClient.method(HttpMethod.POST)
                .uri("/user")
                .body(user, User.class);
    }
}
