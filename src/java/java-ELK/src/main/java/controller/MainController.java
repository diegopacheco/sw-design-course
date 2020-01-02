package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController{

    @RequestMapping("/")
    public String index() {
      return "Greetings from Spring Boot 2x!";
    }

}