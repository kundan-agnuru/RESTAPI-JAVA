package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
@Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
    return args -> {
        User lewa = new User("Lewandoski", "Roberto", "Bayern Munich");
        User müller = new User("thomas", "Müller","Bayern Munich");

        userRepository.saveAll(List.of(lewa, müller));
    };
}
}
