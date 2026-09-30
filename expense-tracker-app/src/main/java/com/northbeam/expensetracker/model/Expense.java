package com.northbeam.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Expense {
    private String id;
    private double amount;
    private String currency;
    private String date;
    private String description;
    @JsonProperty("category_id")
    private String categoryId;
    private String status; // unclaimed | claimed
    @JsonProperty("receipt_url")
    private String receiptUrl;
    @JsonProperty("created_by")
    private String createdBy;

    public Expense() {}

    public Expense(String id, double amount, String currency, String date,
                   String description, String categoryId, String status,
                   String receiptUrl, String createdBy) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.description = description;
        this.categoryId = categoryId;
        this.status = status;
        this.receiptUrl = receiptUrl;
        this.createdBy = createdBy;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReceiptUrl() { return receiptUrl; }
    public void setReceiptUrl(String receiptUrl) { this.receiptUrl = receiptUrl; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}
