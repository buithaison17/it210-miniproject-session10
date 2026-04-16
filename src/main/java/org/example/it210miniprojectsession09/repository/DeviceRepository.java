package org.example.it210miniprojectsession09.repository;

import org.example.it210miniprojectsession09.model.entity.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DeviceRepository {

    private final List<Device> devices = new ArrayList<>();
    private Long nextId = 1L;

    public List<Device> findAll() {
        return devices;
    }

    public Optional<Device> findById(Long id) {
        return devices.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public void save(Device device) {
        if (device.getId() == null) {
            device.setId(nextId++);
            devices.add(device);
        } else {
            // update
            findById(device.getId()).ifPresent(existing -> {
                existing.setName(device.getName());
                existing.setQuantityAvailable(device.getQuantityAvailable());
            });
        }
    }

    public void deleteById(Long id) {
        devices.removeIf(d -> d.getId().equals(id));
    }
}
