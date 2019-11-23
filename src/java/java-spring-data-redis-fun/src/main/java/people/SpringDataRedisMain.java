package people;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataRedisMain {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisMain.class, args);
    }
    
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Running Spring Boot application in Console... ");

            SimpleService service = ctx.getBean(SimpleService.class);
            System.out.println("All People :" + service.getAllPeople("people"));

        };
    }
}

