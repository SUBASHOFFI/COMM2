package com.gift.website.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.website.Modal.Users;
import com.gift.website.Repository.Userrepo;

@Service
public class UserService {
    @Autowired
    private Userrepo userRepository;

    public Users postUser(Users user) {
        return userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(int id) {
        return userRepository.findById(id);
    }
}
