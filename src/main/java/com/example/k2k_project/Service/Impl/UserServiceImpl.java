package com.example.k2k_project.Service.Impl;

import com.example.k2k_project.Data.*;
import com.example.k2k_project.Entity.*;
import com.example.k2k_project.Repository.*;
import com.example.k2k_project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void changeUser(String id, UserDto userDto) {
        Optional<User> selected_user = userRepository.findById(id);
        User user;
        if (selected_user.isPresent()) {
            user = selected_user.get();
            user.setName(userDto.getName());
            user.setAddress(userDto.getAddress());
            user.setPhone_num(userDto.getPhone_num());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        Optional<User> selectedUser = userRepository.findById(id);
        if (selectedUser.isPresent()) {
            userRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
