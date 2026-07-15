package com.example.neontask.repository;

import com.example.neontask.dto.ResourceResponse;
import com.example.neontask.entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    @Query("""
            select new com.example.neontask.dto.ResourceResponse(
                    r.id,
                    r.title,
                    r.description
            )
            from Resource r
            join r.accessRules ar
            where ar.allowedOrganizationId = :organizationId
            """)
    Page<ResourceResponse> findAccessibleResources(
            @Param("organizationId") String organizationId,
            Pageable pageable
    );

}