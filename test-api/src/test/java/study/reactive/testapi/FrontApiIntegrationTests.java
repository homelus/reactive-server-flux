package study.reactive.testapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import study.reactive.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FrontApiIntegrationTests {

    @Test
    void insertUser() {
        User user = new User();
        user.setName("jun");
        user.setType("IN");
        user.setLocation("seoul");
        user.setAge(30);

        User updatedUser = WebClient.create("http://localhost:8891")
                .post()
                .uri("/user")
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(User.class)
                .block();

        user.setId(updatedUser.getId());

        assertEquals(user, updatedUser);
    }

}
