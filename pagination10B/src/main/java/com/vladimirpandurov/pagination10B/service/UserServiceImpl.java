package com.vladimirpandurov.pagination10B.service;

import com.vladimirpandurov.pagination10B.domain.User;
import com.vladimirpandurov.pagination10B.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl {
    private final UserRepository userRepository;

    public Page<User> getUsers(String name, int page, int size){
        log.info("Fetching users for page {} of size {}", page, size);
        return userRepository.findByNameContaining(name, PageRequest.of(page, size));
    }

}
