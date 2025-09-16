package com.example.healthplaces;

public class Model {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String type;

    public Model(String id, String name, String address, String phone, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.type = type;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getType() { return type; }
}
