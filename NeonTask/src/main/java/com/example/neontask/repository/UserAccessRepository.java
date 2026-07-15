package com.example.neontask.repository;

import com.example.neontask.entity.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {
    Optional<UserAccess> findByUsernameAndOrganizationId(
            String username,
            String organizationId
    );

    Optional<UserAccess> findByUsername(String username);
}
