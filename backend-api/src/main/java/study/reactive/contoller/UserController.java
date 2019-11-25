package study.reactive.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import study.reactive.model.User;
import study.reactive.repository.UserRepository;

/**
 * @author playjun
 * @since 2019 11 25
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/user")
    public void insert(User user) {
        userRepository.insert(user);
    }
}
