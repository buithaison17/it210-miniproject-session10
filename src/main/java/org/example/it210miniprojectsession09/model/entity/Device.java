package org.example.it210miniprojectsession09.model.entity;

public class Device {
    private String id;
    private String name;
    private int quantityAvailable;

    public Device(String id, String name, int quantityAvailable) {
        this.id = id;
        this.name = name;
        this.quantityAvailable = quantityAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
