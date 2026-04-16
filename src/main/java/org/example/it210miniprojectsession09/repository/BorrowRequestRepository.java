package org.example.it210miniprojectsession09.repository;

import org.example.it210miniprojectsession09.model.entity.BorrowRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BorrowRequestRepository {
    private List<BorrowRequest> borrowRequests = new ArrayList<>();

    public List<BorrowRequest> findAll() {
        return borrowRequests;
    }
}
