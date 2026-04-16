package org.example.it210miniprojectsession09.repository;

import org.example.it210miniprojectsession09.model.entity.LabRoom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LabRoomRepository {
    private static final List<LabRoom> rooms = new ArrayList<>();

    static {
        rooms.add(new LabRoom("1", "Phong Lab A", "Phong thi nghiem A voi thiet bi hien dai", 30));
        rooms.add(new LabRoom("2", "Phong Lab B", "Phong thi nghiem B voi thiet bi day du", 25));
    }

    public List<LabRoom> findAll() {
        return rooms;
    }
}
