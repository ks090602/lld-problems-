package com.example.ridesharing.repository.userrepo;

import java.util.List;

import com.example.ridesharing.model.User;
import com.example.ridesharing.repository.IRepo;

public interface UserRepo extends IRepo<String,User>{
    List<User> getAllUsers();
}
