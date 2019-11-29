package study.reactive.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import study.reactive.domain.User;
import study.reactive.repository.UserRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

/**
 * @author playjun
 * @since 2019 11 25
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<User> insert(User user) {
        return Mono.just(userRepository.save(user));
    }

    public List<User> getInternalUsers() {
        log.info("getInternalUsers called");
        return userRepository.findByType("IN");
    }

    public List<User> getExternalUsers() {
        log.info("getExternalUsers called");
        return userRepository.findByType("EX");
    }

    public List<User> getSpecialUsers() {
        log.info("getSpecialUsers called");
        return userRepository.findByType("SP");
    }

}
