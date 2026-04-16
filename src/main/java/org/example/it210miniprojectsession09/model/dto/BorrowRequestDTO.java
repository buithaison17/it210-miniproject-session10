package org.example.it210miniprojectsession09.model.dto;

import jakarta.validation.constraints.*;
import org.example.it210miniprojectsession09.annotation.OutOfQuantity;
import org.example.it210miniprojectsession09.annotation.StartDateLessThanEndDateValid;
import org.example.it210miniprojectsession09.annotation.StudentCodeValid;
import org.example.it210miniprojectsession09.type.RequestStatus;

import java.time.LocalDate;

@StartDateLessThanEndDateValid(message = "Ngày bắt đầu phải nhỏ hơn ngày kết thúc")
@OutOfQuantity(message = "Không đủ số lượng")
public class BorrowRequestDTO {
    @NotBlank(message = "Tên sinh viên không được để trống")
    private String studentName;

    @NotNull(message = "Mã sinh viên không được để trống")
    @StudentCodeValid(message = "Mã sinh viên phải bắt đầu bằng SV_")
    private String studentCode;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private Integer quantity;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    @Future(message = "Ngày bắt đầu phải là ngày trong tương lai")
    private LocalDate startDate;

    @NotNull(message = "Ngày kết thúc không được để trống")
    private LocalDate endDate;

    @NotBlank(message = "Lý do mượn không được để trống")
    private String reason;

    @NotNull(message = "Mã thiết bị hoặc phòng thí nghiệm không được để trống")
    private Long deviceOrLabRoomId;

    private RequestStatus status;

    public BorrowRequestDTO() {
    }

    public BorrowRequestDTO(String studentName, String studentCode, String email, Integer quantity, LocalDate startDate, LocalDate endDate, String reason, Long deviceOrLabRoomId, RequestStatus status) {
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

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
