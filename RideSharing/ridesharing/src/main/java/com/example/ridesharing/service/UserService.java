package com.example.ridesharing.service;

import java.util.List;

import com.example.ridesharing.exceptions.UserNotFoundException;
import com.example.ridesharing.model.User;
import com.example.ridesharing.repository.userrepo.UserRepo;

public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo)
    {   
        this.userRepo = userRepo;
    }

    public User getUserById(String id)
    {
        return userRepo.getById(id).orElseThrow(()-> new UserNotFoundException(id));
    }    

    
    public void saveUser(User u)
    {
        userRepo.save(u);
    }

    public void removeUser(String userId)
    {
        userRepo.remove(userId);
    }

    public List<User> getAllUsers()
    {
        return userRepo.getAllUsers();
    }
}
