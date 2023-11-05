package com.example.k2k_project.Service;

import com.example.k2k_project.Data.*;
import com.example.k2k_project.Entity.*;

import java.util.List;

public interface UserService {
    User getUser(String id);
    void saveUser(User user);
    void changeUser(String id, UserDto userDto);
    List<User> findUsers();
    void deleteUser(String id);
}
