package com.dr.backend.repo;

import com.dr.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Email se user dhundne ke liye (Spring Security isko use karega)
    Optional<User> findByEmail(String email);

    // Email duplicate to nahi hai check karne ke liye
    boolean existsByEmail(String email);
}
