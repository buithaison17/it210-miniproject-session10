package org.example.it210miniprojectsession09.service;

import org.example.it210miniprojectsession09.model.entity.Device;
import org.example.it210miniprojectsession09.model.entity.LabRoom;
import org.example.it210miniprojectsession09.repository.DeviceRepository;
import org.example.it210miniprojectsession09.repository.LabRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private LabRoomRepository labRoomRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public List<LabRoom> getAllLabRooms() {
        return labRoomRepository.findAll();
    }
}
