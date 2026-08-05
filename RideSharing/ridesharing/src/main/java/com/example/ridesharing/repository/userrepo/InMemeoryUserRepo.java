package com.example.ridesharing.repository.userrepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.example.ridesharing.model.User;

public class InMemeoryUserRepo implements UserRepo{
    private final Map<String,User> users;
    public InMemeoryUserRepo(){
        users = new ConcurrentHashMap<>();
    }
    
    @Override
    public Optional<User> getById(String id)
    {
        return Optional.ofNullable(users.get(id));
    }    

    @Override
    public void save(User u)
    {
        users.put(u.getId(), u);
    }

    @Override
    public void remove(String userId)
    {
        users.remove(userId);
    }

    @Override
    public List<User> getAllUsers()
    {
        return new ArrayList<>(users.values());
    }
}
