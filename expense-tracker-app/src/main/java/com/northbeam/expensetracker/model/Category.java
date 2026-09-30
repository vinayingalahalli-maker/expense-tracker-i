package com.northbeam.expensetracker.model;

public class Category {
    private String id;
    private String name;
    private String description;
    private int receiptThreshold;
    private String currency;

    public Category() {}

    public Category(String id, String name, String description, int receiptThreshold, String currency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.receiptThreshold = receiptThreshold;
        this.currency = currency;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getReceiptThreshold() { return receiptThreshold; }
    public void setReceiptThreshold(int receiptThreshold) { this.receiptThreshold = receiptThreshold; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
