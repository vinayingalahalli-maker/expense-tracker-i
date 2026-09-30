package com.northbeam.expensetracker.service;

import com.northbeam.expensetracker.model.Category;
import com.northbeam.expensetracker.store.DataStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final DataStore store;

    public CategoryService(DataStore store) {
        this.store = store;
    }

    public List<Category> listAll() {
        return List.copyOf(store.categories.values());
    }

    public Optional<Category> findById(String id) {
        return Optional.ofNullable(store.categories.get(id));
    }

    public Category create(Category input) {
        String id = store.nextCategoryId();
        Category cat = new Category(id, input.getName(), input.getDescription(),
                input.getReceiptThreshold(), input.getCurrency());
        store.categories.put(id, cat);
        return cat;
    }

    public Optional<Category> update(String id, Category input) {
        Category existing = store.categories.get(id);
        if (existing == null) return Optional.empty();
        if (input.getName() != null)        existing.setName(input.getName());
        if (input.getDescription() != null) existing.setDescription(input.getDescription());
        if (input.getReceiptThreshold() > 0) existing.setReceiptThreshold(input.getReceiptThreshold());
        if (input.getCurrency() != null)    existing.setCurrency(input.getCurrency());
        return Optional.of(existing);
    }
}
