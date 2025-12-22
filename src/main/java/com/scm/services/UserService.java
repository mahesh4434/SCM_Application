package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String id);
    // Optional mhnje asa ek datatype ahe ki jo sangto aplyala ki USer ahe ka nhi
    // ahe te

    User updateUser(User user);

    void deleteUser(String id);

    boolean isUserExist(String userId);

    boolean isUserExistByEmail(String email);

    List<User> getAllUsers();

    // Add more methods realeted to user
}
