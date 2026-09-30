package com.northbeam.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Claim {
    private String id;
    private String title;
    private String status; // draft | submitted | approved | rejected | reimbursed
    @JsonProperty("expense_ids")
    private List<String> expenseIds;
    @JsonProperty("total_amount")
    private double totalAmount;
    private String currency;
    @JsonProperty("created_by")
    private String createdBy;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("submitted_at")
    private String submittedAt;
    @JsonProperty("rejection_reason")
    private String rejectionReason;

    public Claim() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<String> getExpenseIds() { return expenseIds; }
    public void setExpenseIds(List<String> expenseIds) { this.expenseIds = expenseIds; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(String submittedAt) { this.submittedAt = submittedAt; }

    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
}
