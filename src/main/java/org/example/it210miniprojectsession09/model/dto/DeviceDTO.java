package org.example.it210miniprojectsession09.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class DeviceDTO {

    private Long id;

    @NotBlank(message = "Tên thiết bị không được để trống")
    private String name;

    @Positive(message = "Số lượng phải là số nguyên dương")
    private int quantityAvailable;

    // Constructor mặc định
    public DeviceDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Constructor đầy đủ
    public DeviceDTO(String name, int quantityAvailable) {
        this.name = name;
        this.quantityAvailable = quantityAvailable;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}
