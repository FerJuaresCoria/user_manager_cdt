package com.cdt.usermanager.controllers;

import com.cdt.usermanager.domains.UserData;
import com.cdt.usermanager.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class UsermanagerController {

    @Autowired
    private UserManagerService service;

    @PostMapping(value = "/users")
    public ResponseEntity<UserData> createUser(@RequestBody UserData request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.createUser(request));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserData> getUser(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getUser(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
