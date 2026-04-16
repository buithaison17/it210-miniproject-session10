package org.example.it210miniprojectsession09.model.entity;

import org.example.it210miniprojectsession09.type.RequestStatus;

import java.time.LocalDate;

public class BorrowRequest {
    private String id;

    private String studentName;
    private String studentCode;
    private String email;
    private Integer quantity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private Long deviceOrLabRoomId;
    private RequestStatus status;

    public BorrowRequest(String id, String studentName, String studentCode, String email, Integer quantity, LocalDate startDate, LocalDate endDate, String reason, Long deviceOrLabRoomId, RequestStatus status) {
        this.id = id;
        this.studentName = studentName;
        this.studentCode = studentCode;
        this.email = email;
        this.quantity = quantity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.deviceOrLabRoomId = deviceOrLabRoomId;
        this.status = status;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getDeviceOrLabRoomId() {
        return deviceOrLabRoomId;
    }

    public void setDeviceOrLabRoomId(Long deviceOrLabRoomId) {
        this.deviceOrLabRoomId = deviceOrLabRoomId;
    }
}
