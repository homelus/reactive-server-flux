package study.reactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import study.reactive.client.UserClient;
import study.reactive.model.User;

/**
 * @author playjun
 * @since 2019 11 25
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserClient userClient;

    @PostMapping("/user}")
    public void insert(User user) {
        userClient.insert(user);
    }

}
