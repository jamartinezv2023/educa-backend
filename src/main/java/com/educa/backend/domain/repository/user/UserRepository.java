package com.educa.backend.domain.repository.user.UserRepository;

package com.educa.backend.domain.repository;

import com.educa.backend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

