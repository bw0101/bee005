package com.bee.bee005.controllers;

import com.bee.bee005.models.Bee;
import com.bee.bee005.repositories.BeeRepository;
import com.bee.bee005.services.Bee005Service;
import com.bee.bee005.services.BeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Bee005Controller {

    private Bee005Service srvc;

    private BeeService beeService;

    private BeeRepository repo;

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi!";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return srvc.showGreeting();
    }
    @GetMapping("/sourcepath")
    public String sourcePath() {
        return srvc.getSourcePath();
    }
    @GetMapping("/destinationpath")
    public String destinationPath() {
        return srvc.getDestinationPath();
    }

    @GetMapping("/goodbye")
    public String saygoodbye() {
        return  srvc.sayGoodbye() ;
    }


    @GetMapping(value = "/bees")
    public Iterable<Bee> list() {
        return beeService.list();
    }
    @GetMapping(value = "/bee2")
    public Iterable<Bee> bee2() {
        return repo.findAll();
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public void handleNotFound(Exception ex) {

        // return empty 404
    }

}
