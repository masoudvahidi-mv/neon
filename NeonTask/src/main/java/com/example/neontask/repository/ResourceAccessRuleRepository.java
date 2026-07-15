package com.example.neontask.repository;

import com.example.neontask.entity.ResourceAccessRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceAccessRuleRepository extends JpaRepository<ResourceAccessRule, Long> {
}
