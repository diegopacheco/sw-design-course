package springboot2x.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController{

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String index() {
      LOGGER.info("Serving a success request. Dont do this in PROD!");
      return "Greetings from Spring Boot 2x!";
    }

}
