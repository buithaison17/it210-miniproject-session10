package org.example.it210miniprojectsession09.service;

import org.example.it210miniprojectsession09.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Integer getQuantity(Long deviceId) {
        return deviceRepository.findAll().stream().filter(p -> p.getId() == deviceId).findFirst().get().getQuantityAvailable();
    }
}
