package com.cdt.usermanager.services;

import com.cdt.usermanager.domains.UserData;
import com.cdt.usermanager.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * UserManagerService is a service that manages the main logic of the Controller
 */

@Service
public class UserManagerService {

    private final Users users;

    /**
     * Constructor of the service
     *
     * @param users is the repository of users
     */
    @Autowired
    public UserManagerService(Users users) {
        this.users = users;
    }

    /**
     * Register a user
     *
     * @param userData necessary info of a user
     * @return the complete user registered
     * @throws DataIntegrityViolationException if the user has invalid information
     */
    public UserData createUser(UserData userData) {
        return users.save(userData);
    }

    /**
     * Search for a user by the id
     *
     * @param id user identification
     * @return the specified user
     * @throws NoSuchElementException if the user is not found
     */
    public UserData getUser(String id) {
        return users.findById(id).get();
    }

}
