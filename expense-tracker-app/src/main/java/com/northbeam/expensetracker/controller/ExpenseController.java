package com.northbeam.expensetracker.controller;

import com.northbeam.expensetracker.model.ErrorResponse;
import com.northbeam.expensetracker.model.Expense;
import com.northbeam.expensetracker.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> list(@RequestParam(required = false) String status) {
        return service.listAll(status);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Expense input) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.create(input));
        } catch (IllegalArgumentException e) {
            String[] parts = e.getMessage().split(":", 2);
            if ("date_future".equals(parts[0])) {
                return ResponseEntity.badRequest()
                        .body(new ErrorResponse("validation_error", parts[1]));
            }
            return ResponseEntity.badRequest().body(new ErrorResponse("validation_error", e.getMessage()));
        } catch (IllegalStateException e) {
            String[] parts = e.getMessage().split(":", 2);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(new ErrorResponse(parts[0], parts.length > 1 ? parts[1] : e.getMessage()));
        }
    }

    @GetMapping("/{expense_id}")
    public ResponseEntity<?> get(@PathVariable("expense_id") String id) {
        return service.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Expense " + id + " does not exist")));
    }

    @PutMapping("/{expense_id}")
    public ResponseEntity<?> update(@PathVariable("expense_id") String id, @RequestBody Expense input) {
        try {
            Expense updated = service.update(id, input);
            if (updated == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Expense " + id + " does not exist"));
            }
            return ResponseEntity.ok(updated);
        } catch (IllegalStateException e) {
            String[] parts = e.getMessage().split(":", 2);
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErrorResponse(parts[0], parts.length > 1 ? parts[1] : e.getMessage()));
        }
    }

    @DeleteMapping("/{expense_id}")
    public ResponseEntity<?> delete(@PathVariable("expense_id") String id) {
        try {
            boolean deleted = service.delete(id);
            if (!deleted) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Expense " + id + " does not exist"));
            }
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            String[] parts = e.getMessage().split(":", 2);
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErrorResponse(parts[0], parts.length > 1 ? parts[1] : e.getMessage()));
        }
    }
}
