package com.northbeam.expensetracker.controller;

import com.northbeam.expensetracker.model.Claim;
import com.northbeam.expensetracker.model.ErrorResponse;
import com.northbeam.expensetracker.service.ClaimService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService service;

    public ClaimController(ClaimService service) {
        this.service = service;
    }

    @GetMapping
    public List<Claim> list(@RequestParam(required = false) String status) {
        return service.listAll(status);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Claim input) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.create(input));
        } catch (IllegalArgumentException e) {
            String[] parts = e.getMessage().split(":", 2);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(new ErrorResponse(parts[0], parts.length > 1 ? parts[1] : e.getMessage()));
        }
    }

    @GetMapping("/{claim_id}")
    public ResponseEntity<?> get(@PathVariable("claim_id") String id) {
        return service.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Claim " + id + " does not exist")));
    }

    @PostMapping("/{claim_id}/submit")
    public ResponseEntity<?> submit(@PathVariable("claim_id") String id) {
        return service.submit(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Claim " + id + " does not exist")));
    }

    @PostMapping("/{claim_id}/approve")
    public ResponseEntity<?> approve(@PathVariable("claim_id") String id) {
        return service.approve(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Claim " + id + " does not exist")));
    }

    @PostMapping("/{claim_id}/reject")
    public ResponseEntity<?> reject(@PathVariable("claim_id") String id,
                                    @RequestBody(required = false) Map<String, String> body) {
        String reason = body != null ? body.getOrDefault("reason", "") : "";
        return service.reject(id, reason)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Claim " + id + " does not exist")));
    }

    @PostMapping("/{claim_id}/reimburse")
    public ResponseEntity<?> reimburse(@PathVariable("claim_id") String id) {
        return service.reimburse(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("not_found", "Claim " + id + " does not exist")));
    }
}
