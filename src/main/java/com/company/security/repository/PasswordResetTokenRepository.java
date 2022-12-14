package com.company.security.repository;
import com.company.security.model.PasswordResetToken;
import com.company.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    Optional<PasswordResetToken> findByToken(String token);

    @Query("SELECT t FROM PASSWORD_RESET_TOKEN t WHERE t.active = true and t.user = :user")
    List<PasswordResetToken> findActiveTokensForUser(User user);
}
