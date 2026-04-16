package org.example.it210miniprojectsession09.controller;

import jakarta.validation.Valid;
import org.example.it210miniprojectsession09.model.dto.BorrowRequestDTO;
import org.example.it210miniprojectsession09.service.BorrowRequestService;
import org.example.it210miniprojectsession09.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    private BorrowRequestService borrowRequestService;

    public StudentController(StudentService studentService, BorrowRequestService borrowRequestService) {
        this.studentService = studentService;
        this.borrowRequestService = borrowRequestService;
    }

    @GetMapping("/form-borrow/{borrow_id}")
    public String showFormBorrow(
            @PathVariable("borrow_id") String borrowId,
            Model model) {
        BorrowRequestDTO borrowRequestDTO = new BorrowRequestDTO();
        borrowRequestDTO.setDeviceOrLabRoomId(borrowId);
        model.addAttribute("borrowDto", borrowRequestDTO);
        return "form-borrow";
    }

    @PostMapping("/borrow/{borrow_id}")
    public String borrow(
            @PathVariable("borrow_id") String borrowId,
            @Valid @ModelAttribute("borrowDto") BorrowRequestDTO borrowRequestDTO,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        borrowRequestDTO.setDeviceOrLabRoomId(borrowId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("borrowDto", borrowRequestDTO);
            return "form-borrow";
        }
        borrowRequestService.save(borrowRequestDTO);
        redirectAttributes.addFlashAttribute("message", "Đăng ký mượn thành công");
        return "redirect:/student/catalog";
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
