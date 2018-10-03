package ch.guillod.apps.band.manager;

import ch.guillod.apps.band.manager.controller.repository.MusicianRepository;
import ch.guillod.apps.band.manager.domain.Musician;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MusicianRepository musicianRepository) {
        return args -> {
            for (Musician musician : musicianRepository.findAll()) {
                LOGGER.info(musician.toString());
            }
        };
    }
}
