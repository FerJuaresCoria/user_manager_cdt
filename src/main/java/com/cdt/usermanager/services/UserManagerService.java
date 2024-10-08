package com.cdt.usermanager.services;

import com.cdt.usermanager.domains.UserData;
import com.cdt.usermanager.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserManagerService {

    private final Users users;

    @Autowired
    public UserManagerService(Users users) {
        this.users = users;
    }

    public UserData createUser(UserData userData) {
        return users.save(userData);
    }

    public UserData getUser(String id) {
        return users.findById(id).get();
    }

}
