package com.vladimirpandurov.pagination10B.repository;

import com.vladimirpandurov.pagination10B.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findByNameContaining(String name, Pageable pageable);
}
