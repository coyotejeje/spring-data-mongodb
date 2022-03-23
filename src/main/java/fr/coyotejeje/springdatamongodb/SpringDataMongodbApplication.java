package fr.coyotejeje.springdatamongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class SpringDataMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataMongodbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
       return args -> {
           Address address = new Address(
                   "France",
                   "Lyon",
                   "69000"
           );
           Student student = new Student(
                   "John",
                   "Doe",
                   "john.doe@gmail.com",
                   Gender.MALE,
                   address,
                   List.of("Computer Science", "Maths"),
                   BigDecimal.TEN,
                   LocalDateTime.now()
           );

           repository.insert(student);
       };
    }

}
