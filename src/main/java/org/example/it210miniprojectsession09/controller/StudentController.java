package org.example.it210miniprojectsession09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/form-borrow")
    public String showFormBorrow() {
        return "form-borrow";
    }
}
