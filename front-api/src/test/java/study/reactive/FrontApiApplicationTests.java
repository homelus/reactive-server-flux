package study.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import study.reactive.domain.User;

@SpringBootTest
class FrontApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void client() {
        User user = new User();
        user.setName("jun");
        user.setAge(11);

        Mono<User> userMono = WebClient.create("http://localhost:8892")
                .post()
                .uri("/user")
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(User.class);


        User result = userMono.block();
        System.out.println(result.toString());

//        userMono.subscribe(System.out::println,
//                System.err::println,
//                () -> System.out.println("complete"));
    }

}
