package people;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataRedisRepositoryMain{
    
    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisRepositoryMain.class, args);
    }
    
    @Bean
    public CommandLineRunner commandLineRunnerMapper(ApplicationContext ctx) {
        return args -> {

            System.out.println("Running Spring Boot application in Console... ");

            PersonRepository repo = ctx.getBean(PersonRepository.class);
            Person p = new Person("diegopacheco", "diego.pacheco.it@gmail.com");
            repo.save(p);                                         
            System.out.println("Persons: " + repo.findAll());
            System.out.println("Count: " + repo.count());
            repo.delete(p);  
        };
    }

}

