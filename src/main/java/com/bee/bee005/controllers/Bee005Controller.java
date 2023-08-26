package com.bee.bee005.controllers;

import com.bee.bee005.models.Bee;
import com.bee.bee005.models.Files;
import com.bee.bee005.repositories.BeeRepository;
import com.bee.bee005.repositories.FilesRepository;
import com.bee.bee005.services.Bee005Service;
import com.bee.bee005.services.BeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
public class Bee005Controller {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Bee005Service srvc;

    private BeeService beeService;

    private BeeRepository repo;

    private FilesRepository filesRepo;

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

    @GetMapping(value = "/files")
    public Iterable<Files> files() {
        return filesRepo.findAll();
    }


   /* @GetMapping("/file/new")
    public String showCreateForm(Model model) {
        *//*Files file = filesRepo.findById(fileId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid file Id: " + fileId));*//*

        Files file = new Files();
        file.setVersion("1.0");
        file.setPath("C:\\Work\\");
        file.setType("txt");
        file.setDescription("Test file");

        model.addAttribute("file", file);
        return "newfileform"; // Name of the Thymeleaf template (newfileform.html)
    }
    @GetMapping("/file/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long fileId, Model model) {
        Files file = filesRepo.findById(fileId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid file Id: " + fileId));

        model.addAttribute("file", file);
        return "updateForm"; // Name of the Thymeleaf template (updateForm.html)
    }*/

    @GetMapping(value = "/files/{id}")
    public Files getFile(@PathVariable int id) {
        return retrieveFile(id);
    }

    private Files retrieveFile(long id) throws IllegalArgumentException {
        Files file = filesRepo.findById(id).orElse(null);
        if (file == null) {
            throw new IllegalArgumentException(" getFile called in Controller and No such file with id " + id);
        }
        return file;
    }

    /**
     * Maps UnsupportedOperationException to a 501 Not Implemented HTTP status
     * code.
     */
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler({ UnsupportedOperationException.class })
    public void handleUnabletoReallocate(Exception ex) {
        logger.error("Exception is: ", ex);
        // just return empty 501
    }

    /**
     * Maps IllegalArgumentExceptions to a 404 Not Found HTTP status code.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public void handleNotFound(Exception ex) {
        logger.error("Exception is: ", ex);
        // return empty 404
    }

    /**
     * Maps DataIntegrityViolationException to a 409 Conflict HTTP status code.
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ DataIntegrityViolationException.class })
    public void handleAlreadyExists(Exception ex) {
        logger.error("Exception is: ", ex);
        // return empty 409
    }


    @PostMapping(value = "/file")
    public ResponseEntity<Void> createFile(@RequestBody Files newFile) {
        Files file = filesRepo.save(newFile);
        return entityWithLocation(file.getId());
    }
    private ResponseEntity<Void> entityWithLocation(Object resourceId) {

        // Determines URL of child resource based on the full URL of the given
        // request, appending the path info with the given resource Identifier
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{resourceId}")
                .buildAndExpand(resourceId)
                .toUri();

        // Return an HttpEntity object - it will be used to build the
        // HttpServletResponse
        return ResponseEntity.created(location).build();
    }

}
