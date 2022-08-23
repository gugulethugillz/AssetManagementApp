package com.gugulethuapps.AssetManagementApp.User.service;

import com.gugulethuapps.AssetManagementApp.User.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(int id);
    void delete(int id);
    void save(User user);
}
