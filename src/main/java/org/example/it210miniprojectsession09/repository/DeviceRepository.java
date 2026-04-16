package org.example.it210miniprojectsession09.repository;

import org.example.it210miniprojectsession09.model.entity.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeviceRepository {
    private static final List<Device> devices = new ArrayList<>();

    static {
        devices.add(new Device("1", "Man hinh Dell", "/images/monitor.jpg", 5));
        devices.add(new Device("2", "Cap HDMI", "/images/hdmi.jpg", 10));
    }

    public List<Device> findAll() {
        return devices;
    }
}
