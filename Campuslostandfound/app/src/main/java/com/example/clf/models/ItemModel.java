package com.example.clf.models;

import java.io.Serializable;

public class ItemModel implements Serializable {
    private String id;
    private String name;
    private String status; // "Lost" or "Found"
    private String category;
    private String location;
    private String date;
    private String description;

    public ItemModel(String id, String name, String status, String category, String location, String date, String description) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.category = category;
        this.location = location;
        this.date = date;
        this.description = description;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getStatus() { return status; }
    public String getCategory() { return category; }
    public String getLocation() { return location; }
    public String getDate() { return date; }
    public String getDescription() { return description; }
}