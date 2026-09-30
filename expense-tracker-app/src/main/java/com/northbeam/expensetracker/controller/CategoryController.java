package com.northbeam.expensetracker.controller;

import com.northbeam.expensetracker.model.Category;
import com.northbeam.expensetracker.model.ErrorResponse;
import com.northbeam.expensetracker.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> list() {
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Category input) {
        if (input.getName() == null || input.getName().isBlank()) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("validation_error", "name is required; receipt_threshold must be a positive number"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(input));
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<?> get(@PathVariable("category_id") String id) {
        return service.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Category " + id + " does not exist")));
    }

    @PutMapping("/{category_id}")
    public ResponseEntity<?> update(@PathVariable("category_id") String id, @RequestBody Category input) {
        return service.update(id, input)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Category " + id + " does not exist")));
    }
}
