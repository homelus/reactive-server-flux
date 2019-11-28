package study.reactive.testapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import study.reactive.domain.User;

@SpringBootTest
class FrontApiIntegrationTests {



    @BeforeTestClass
    public void setUp() {
    }

    @Test
    void insertUser() {
        User user = new User("jun", "seoul", 30);

        User updatedUser = WebClient.create("localhost:8891")
                .post()
                .uri("/user")
                .body(user, User.class)
                .retrieve()
                .bodyToMono(User.class)
                .block();

        System.out.println(updatedUser);
    }

}
