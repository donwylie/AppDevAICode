package com.example.pethouseholdapp.controller;

import com.example.pethouseholdapp.entity.User;
import com.example.pethouseholdapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{id}/reset-password")
    public ResponseEntity<User> resetPassword(@PathVariable Long id, @RequestParam String newPassword) {
        return ResponseEntity.ok(userService.resetPassword(id, newPassword));
    }

    @PutMapping("/{id}/toggle-unlocked")
    public ResponseEntity<User> toggleUnlocked(@PathVariable Long id) {
        return ResponseEntity.ok(userService.toggleUnlocked(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}