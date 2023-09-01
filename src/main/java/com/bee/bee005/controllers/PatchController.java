package com.bee.bee005.controllers;

import com.bee.bee005.services.ArtifactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patches")
public class PatchController {

    @Autowired
    private ArtifactoryService artifactoryService;

    @GetMapping
    public String getPatches(Model model) {
        model.addAttribute("patches", artifactoryService.getLatestPatches());
        return "patches";
    }

    @GetMapping("/download/{patchName}")
    public ResponseEntity<?> downloadPatch(@PathVariable String patchName) {
        artifactoryService.downloadPatch(patchName);
        return ResponseEntity.ok("Patch downloaded successfully! ;)");
    }
}

