package com.self.company.service;

import com.self.company.model.User;

public interface UserService {
    User findById(Integer id);
    void deleteById(Integer id);
}
