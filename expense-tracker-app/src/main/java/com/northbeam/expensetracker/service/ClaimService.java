package com.northbeam.expensetracker.service;

import com.northbeam.expensetracker.model.Claim;
import com.northbeam.expensetracker.model.Expense;
import com.northbeam.expensetracker.store.DataStore;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

    private final DataStore store;

    public ClaimService(DataStore store) {
        this.store = store;
    }

    public List<Claim> listAll(String status) {
        return store.claims.values().stream()
                .filter(c -> status == null || status.isBlank() || c.getStatus().equals(status))
                .toList();
    }

    public Optional<Claim> findById(String id) {
        return Optional.ofNullable(store.claims.get(id));
    }

    public Claim create(Claim input) {
        // Validate: no expense older than 90 days
        for (String expId : input.getExpenseIds()) {
            Expense exp = store.expenses.get(expId);
            if (exp != null) {
                LocalDate expDate = LocalDate.parse(exp.getDate());
                if (expDate.isBefore(LocalDate.now().minusDays(90))) {
                    throw new IllegalArgumentException("expense_too_old:Expense " + expId + " is older than 90 days and cannot be added to a claim");
                }
            }
        }

        // Calculate total
        double total = input.getExpenseIds().stream()
                .map(store.expenses::get)
                .filter(e -> e != null)
                .mapToDouble(Expense::getAmount)
                .sum();

        String currency = input.getExpenseIds().stream()
                .map(store.expenses::get)
                .filter(e -> e != null)
                .map(Expense::getCurrency)
                .findFirst().orElse("USD");

        String id = store.nextClaimId();
        Claim claim = new Claim();
        claim.setId(id);
        claim.setTitle(input.getTitle());
        claim.setStatus("draft");
        claim.setExpenseIds(input.getExpenseIds());
        claim.setTotalAmount(total);
        claim.setCurrency(currency);
        claim.setCreatedBy("user_42");
        claim.setCreatedAt(store.nowIso());
        store.claims.put(id, claim);
        return claim;
    }

    public Optional<Claim> submit(String id) {
        Claim claim = store.claims.get(id);
        if (claim == null) return Optional.empty();
        claim.setStatus("submitted");
        claim.setSubmittedAt(store.nowIso());
        // Mark expenses as claimed
        claim.getExpenseIds().forEach(expId -> {
            Expense e = store.expenses.get(expId);
            if (e != null) e.setStatus("claimed");
        });
        return Optional.of(claim);
    }

    public Optional<Claim> approve(String id) {
        Claim claim = store.claims.get(id);
        if (claim == null) return Optional.empty();
        claim.setStatus("approved");
        return Optional.of(claim);
    }

    public Optional<Claim> reject(String id, String reason) {
        Claim claim = store.claims.get(id);
        if (claim == null) return Optional.empty();
        claim.setStatus("rejected");
        claim.setRejectionReason(reason);
        // Unfreeze expenses back to unclaimed
        claim.getExpenseIds().forEach(expId -> {
            Expense e = store.expenses.get(expId);
            if (e != null) e.setStatus("unclaimed");
        });
        return Optional.of(claim);
    }

    public Optional<Claim> reimburse(String id) {
        Claim claim = store.claims.get(id);
        if (claim == null) return Optional.empty();
        claim.setStatus("reimbursed");
        return Optional.of(claim);
    }
}
