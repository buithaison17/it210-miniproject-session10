package org.example.it210miniprojectsession09.controller;

import jakarta.validation.Valid;
import org.example.it210miniprojectsession09.model.dto.DeviceDTO;
import org.example.it210miniprojectsession09.model.dto.DeviceMapper;
import org.example.it210miniprojectsession09.model.entity.Device;
import org.example.it210miniprojectsession09.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    // Hiển thị danh sách thiết bị
    @GetMapping("/device")
    public String listDevices(Model model) {
        List<Device> devices = adminService.getAllDevices();
        model.addAttribute("devices", devices); // sửa lại tên attribute
        return "device-list";
    }

    // Hiển thị form thêm mới
    @GetMapping("/device/add")
    public String showAddForm(Model model) {
        model.addAttribute("device", new DeviceDTO());
        return "device-form";
    }

    // Xử lý thêm mới
    @PostMapping("/device/add")
    public String addDevice(@Valid @ModelAttribute("device") DeviceDTO deviceDTO,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "device-form";
        }
        Device device = DeviceMapper.toEntity(deviceDTO);
        adminService.addDevice(device);
        return "redirect:/admin/device"; // đồng bộ
    }
    // Hiển thị form sửa
    @GetMapping("/device/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Device device = adminService.getDeviceById(id);
        if (device == null) {
            return "redirect:/admin/device";
        }
        model.addAttribute("device", DeviceMapper.toDTO(device));
        return "device-edit"; // dùng giao diện riêng
    }

    // Xử lý cập nhật
    @PostMapping("/device/edit/{id}")
    public String updateDevice(@PathVariable("id") Long id,
                               @Valid @ModelAttribute("device") DeviceDTO deviceDTO,
                               BindingResult result) {
        deviceDTO.setId(id);
        if (result.hasErrors()) {
            return "device-edit";
        }
        Device device = adminService.getDeviceById(id);
        if (device != null) {
            device.setName(deviceDTO.getName());
            device.setQuantityAvailable(deviceDTO.getQuantityAvailable());
            adminService.updateDevice(device);
        }
        return "redirect:/admin/device";
    }

    // Xóa thiết bị
    @GetMapping("/device/delete/{id}")
    public String deleteDevice(@PathVariable("id") Long id) {
        adminService.deleteDevice(id);
        return "redirect:/admin/device"; // đồng bộ
    }
}
