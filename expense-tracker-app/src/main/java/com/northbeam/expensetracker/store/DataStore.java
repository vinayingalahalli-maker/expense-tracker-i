package com.northbeam.expensetracker.store;

import com.northbeam.expensetracker.model.Category;
import com.northbeam.expensetracker.model.Claim;
import com.northbeam.expensetracker.model.Expense;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DataStore {

    public final ConcurrentHashMap<String, Category> categories = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, Expense> expenses = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, Claim> claims = new ConcurrentHashMap<>();

    private final AtomicInteger catSeq = new AtomicInteger(1);
    private final AtomicInteger expSeq = new AtomicInteger(1);
    private final AtomicInteger clmSeq = new AtomicInteger(1);

    public DataStore() {
        // Seed data
        Category travel = new Category("cat_01", "Travel", "Flights, hotels, and ground transport", 50, "USD");
        Category meals  = new Category("cat_02", "Meals",  "Business meals and entertainment",      25, "USD");
        categories.put(travel.getId(), travel);
        categories.put(meals.getId(),  meals);
        catSeq.set(3);

        Expense e1 = new Expense("exp_01", 42.5, "USD", "2026-09-28",
                "Taxi to client site", "cat_01", "unclaimed", null, "user_42");
        Expense e2 = new Expense("exp_02", 18.0, "USD", "2026-09-27",
                "Team lunch", "cat_02", "unclaimed", null, "user_42");
        expenses.put(e1.getId(), e1);
        expenses.put(e2.getId(), e2);
        expSeq.set(3);
    }

    public String nextCategoryId()  { return "cat_" + String.format("%02d", catSeq.getAndIncrement()); }
    public String nextExpenseId()   { return "exp_" + String.format("%02d", expSeq.getAndIncrement()); }
    public String nextClaimId()     { return "clm_" + String.format("%02d", clmSeq.getAndIncrement()); }
    public String nowIso()          { return Instant.now().toString(); }
}
