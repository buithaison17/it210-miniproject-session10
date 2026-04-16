package org.example.it210miniprojectsession09.controller;

import org.example.it210miniprojectsession09.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home() {
        return "redirect:/catalog";
    }

    @GetMapping("/catalog")
    public String viewCatalog(Model model) {
        model.addAttribute("devices", studentService.getAllDevices());
        model.addAttribute("rooms", studentService.getAllLabRooms());
        return "catalog";
    }
}
