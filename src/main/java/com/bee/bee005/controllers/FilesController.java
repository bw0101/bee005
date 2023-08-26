package com.bee.bee005.controllers;

import com.bee.bee005.models.Files;
import com.bee.bee005.repositories.FilesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@AllArgsConstructor
@Controller
public class FilesController {


    private FilesRepository filesRepo;


    @GetMapping("/file/list")
    public String listFiles(Model model) {
        List<Files> filesList = (List<Files>) filesRepo.findAll();
        model.addAttribute("files", filesList);
        return "filelist"; // This matches the name of the Thymeleaf template
    }

    @GetMapping("/file/new")
    public String showCreateForm(Model model) {
        /*Files file = filesRepo.findById(fileId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid file Id: " + fileId));*/

        Long newId = filesRepo.count()+1;

        Files file = new Files();
        file.setId(newId); //getMaxId() + 1);
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
        return "updatefileform"; // Name of the Thymeleaf template (updateForm.html)
    }

    @PostMapping(value = "/savefile")
    public String createFile(@ModelAttribute Files newFile) {
        Files file = filesRepo.save(newFile);
        return "redirect:/file/list";
    }

    @PostMapping(value = "/updatefile")
    public String updateFile(@ModelAttribute Files newFile) {
        Files file = filesRepo.save(newFile);
        return "redirect:/file/list";
    }
    @PostMapping("/file/update")
    public String updateFile(@ModelAttribute Files file, RedirectAttributes redirectAttributes) {
        if (file.getId() == null) {
            redirectAttributes.addFlashAttribute("error", "Invalid file ID.");
            return "redirect:/file/list"; // Redirect to a listing page or error page
        }

        Files existingFile = filesRepo.findById(file.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid file Id: " + file.getId()));

        // Update the entity fields here. This can also be done in a service layer.
        existingFile.setVersion(file.getVersion());
        existingFile.setPath(file.getPath());
        existingFile.setType(file.getType());
        existingFile.setDescription(file.getDescription());

        filesRepo.save(existingFile); // Save the updated entity

        redirectAttributes.addFlashAttribute("message", "File updated successfully.");
        return "redirect:/file/list"; // Redirect to a listing page or a confirmation page
    }


}
