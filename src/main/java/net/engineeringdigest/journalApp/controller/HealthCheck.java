package net.engineeringdigest.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController         // RestController creates a bean, but it also has a special feature
                        // We are writing end-points here and all the end-points and paths and all the returns are converted into json automatically.
public class HealthCheck {

    @GetMapping("/health-check")        // we need to map the below method to a path this can be done using @GetMapping with the path
                                        // meaning the method healthCheck will be mapped to health-check
    public String healthCheck(){
        return "Ok";
    }
}
