package org.example.it210miniprojectsession09.service;

import org.example.it210miniprojectsession09.model.entity.Device;
import org.example.it210miniprojectsession09.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final DeviceRepository deviceRepository;

    public AdminService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    // Lấy tất cả thiết bị
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    // Thêm mới thiết bị
    public void addDevice(Device device) {
        deviceRepository.save(device);
    }

    // Lấy thiết bị theo ID
    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    // Cập nhật thiết bị
    public void updateDevice(Device device) {
        deviceRepository.save(device);
    }

    // Xóa thiết bị
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
