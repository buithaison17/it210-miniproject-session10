package org.example.it210miniprojectsession09.controller;

import jakarta.validation.Valid;
import org.example.it210miniprojectsession09.model.dto.BorrowRequestDTO;
import org.example.it210miniprojectsession09.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/form-borrow")
    public String showFormBorrow(Model model) {
        model.addAttribute("borrowDto", new BorrowRequestDTO());
        return "form-borrow";
    }

    @PostMapping("/borrow")
    public String borrow(
            @Valid @ModelAttribute("borrowDto") BorrowRequestDTO borrowRequestDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "form-borrow";
        }
        return "redirect:/student/form-borrow";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/student/catalog";
    }

    @GetMapping("/catalog")
    public String viewCatalog(Model model) {
        model.addAttribute("devices", studentService.getAllDevices());
        model.addAttribute("rooms", studentService.getAllLabRooms());
        return "catalog";
    }
}
