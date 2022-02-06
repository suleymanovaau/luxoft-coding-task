package com.self.company.service.impl;

import com.self.company.exception.ResourceNotFoundException;
import com.self.company.model.User;
import com.self.company.repository.UserRepository;
import com.self.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Find by PRIMARY_KEY as requested at coding-task at line REQ-02
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found with id = " + id));
    }

    /**
     * Delete by PRIMARY_KEY as requested at coding-task at line REQ-03
     * @param id
     * @return
     */
    @Override
    public void deleteById(Integer id) {
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
           throw  new ResourceNotFoundException("User not found with id = " + id);
        }
    }
}
