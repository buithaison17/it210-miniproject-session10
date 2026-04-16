package org.example.it210miniprojectsession09.service;

import org.example.it210miniprojectsession09.model.dto.BorrowRequestDTO;
import org.example.it210miniprojectsession09.model.entity.BorrowRequest;
import org.example.it210miniprojectsession09.repository.BorrowRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BorrowRequestService {
    private BorrowRequestRepository borrowRequestRepository;

    public BorrowRequestService(BorrowRequestRepository borrowRequestRepository) {
        this.borrowRequestRepository = borrowRequestRepository;
    }

    public List<BorrowRequest> findAll() {
        return borrowRequestRepository.findAll();
    }

    private BorrowRequest mapToBorrowRequest(BorrowRequestDTO borrowRequestDTO) {
        return new BorrowRequest(
                UUID.randomUUID().toString(),
                borrowRequestDTO.getStudentName(),
                borrowRequestDTO.getStudentCode(),
                borrowRequestDTO.getEmail(),
                borrowRequestDTO.getQuantity(),
                borrowRequestDTO.getStartDate(),
                borrowRequestDTO.getEndDate(),
                borrowRequestDTO.getReason(),
                borrowRequestDTO.getDeviceOrLabRoomId(),
                borrowRequestDTO.getStatus()
        );
    }

    public void save(BorrowRequestDTO borrowRequestDTO) {
        BorrowRequest borrowRequest = mapToBorrowRequest(borrowRequestDTO);
        borrowRequestRepository.findAll().add(borrowRequest);
    }
}
