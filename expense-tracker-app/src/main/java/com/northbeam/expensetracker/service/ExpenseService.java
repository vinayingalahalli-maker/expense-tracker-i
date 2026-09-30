package com.northbeam.expensetracker.service;

import com.northbeam.expensetracker.model.Category;
import com.northbeam.expensetracker.model.Expense;
import com.northbeam.expensetracker.store.DataStore;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final DataStore store;

    public ExpenseService(DataStore store) {
        this.store = store;
    }

    public List<Expense> listAll(String status) {
        return store.expenses.values().stream()
                .filter(e -> status == null || status.isBlank() || e.getStatus().equals(status))
                .toList();
    }

    public Optional<Expense> findById(String id) {
        return Optional.ofNullable(store.expenses.get(id));
    }

    /** Returns the created expense, or throws a RuntimeException with a code prefix. */
    public Expense create(Expense input) {
        // Validate: date not in the future
        LocalDate expDate = LocalDate.parse(input.getDate());
        if (expDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("date_future:date cannot be in the future");
        }

        // Validate: receipt required above threshold
        Category cat = store.categories.get(input.getCategoryId());
        if (cat != null && input.getAmount() > cat.getReceiptThreshold() && input.getReceiptUrl() == null) {
            throw new IllegalStateException("receipt_required:A receipt is mandatory for amounts above the category threshold of "
                    + cat.getReceiptThreshold() + ".00 " + cat.getCurrency());
        }

        String id = store.nextExpenseId();
        Expense expense = new Expense(id, input.getAmount(), input.getCurrency(), input.getDate(),
                input.getDescription(), input.getCategoryId(), "unclaimed",
                input.getReceiptUrl(), "user_42");
        store.expenses.put(id, expense);
        return expense;
    }

    public Expense update(String id, Expense input) {
        Expense existing = store.expenses.get(id);
        if (existing == null) return null;
        if (isFrozen(id)) throw new IllegalStateException("expense_frozen:Expense " + id + " is part of a submitted claim and cannot be modified");
        if (input.getAmount() > 0)          existing.setAmount(input.getAmount());
        if (input.getCurrency() != null)    existing.setCurrency(input.getCurrency());
        if (input.getDate() != null)        existing.setDate(input.getDate());
        if (input.getDescription() != null) existing.setDescription(input.getDescription());
        if (input.getCategoryId() != null)  existing.setCategoryId(input.getCategoryId());
        return existing;
    }

    public boolean delete(String id) {
        if (!store.expenses.containsKey(id)) return false;
        if (isFrozen(id)) throw new IllegalStateException("expense_frozen:Expense " + id + " is part of a submitted claim and cannot be deleted");
        store.expenses.remove(id);
        return true;
    }

    /** An expense is frozen if it belongs to a non-draft claim. */
    private boolean isFrozen(String expenseId) {
        return store.claims.values().stream()
                .anyMatch(c -> !c.getStatus().equals("draft") && c.getExpenseIds().contains(expenseId));
    }
}
