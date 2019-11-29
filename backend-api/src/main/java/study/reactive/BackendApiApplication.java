package study.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import study.reactive.domain.UserFactory;
import study.reactive.repository.UserRepository;

import java.util.Collection;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            Stream.of(UserFactory.externalDummyUser(), UserFactory.internalDummyUser(), UserFactory.specialDummyUser())
                    .flatMap(Collection::stream)
                    .forEach(userRepository::save);

            userRepository.findAll().forEach(System.out::println);
        };
    }

}