package com.dikkulah.firstcase.service;

import com.dikkulah.firstcase.entity.User;
import com.dikkulah.firstcase.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor@Slf4j
public class UserService {
    private final UserRepository userRepository;


    public User createUser(User user){
        log.info("User eklendi.");
        return userRepository.save(user);
    }
}
