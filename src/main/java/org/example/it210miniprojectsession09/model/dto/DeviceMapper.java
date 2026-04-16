package org.example.it210miniprojectsession09.model.dto;

import org.example.it210miniprojectsession09.model.entity.Device;

public class DeviceMapper {
    // Convert từ DTO sang Entity
    public static Device toEntity(DeviceDTO dto) {
        Device device = new Device();
        device.setName(dto.getName());
        device.setQuantityAvailable(dto.getQuantityAvailable());
        return device;
    }
    // Convert từ Entity sang DTO
    public static DeviceDTO toDTO(Device entity) {
        DeviceDTO dto = new DeviceDTO();
        dto.setName(entity.getName());
        dto.setQuantityAvailable(entity.getQuantityAvailable());
        return dto;
    }
}
