package com.example.neontask.service;

import com.example.neontask.dto.ResourceRequest;
import com.example.neontask.dto.ResourceResponse;
import com.example.neontask.entity.Resource;
import com.example.neontask.entity.ResourceAccessRule;
import com.example.neontask.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceResponse create(ResourceRequest request) {

        Resource resource = Resource.builder()
                .title(request.title())
                .description(request.description())
                .organizationId(request.organizationId())
                .build();

        ResourceAccessRule rule = ResourceAccessRule.builder()
                .allowedOrganizationId(request.organizationId())
                .resource(resource)
                .build();

        resource.setAccessRules(List.of(rule));

        Resource saved = resourceRepository.save(resource);

        return new ResourceResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getDescription()
        );
    }

    public Page<ResourceResponse> getAccessibleResources(
            Jwt jwt,
            Pageable pageable) {

        String organizationId =
                jwt.getClaimAsString("organization_id");

        return resourceRepository.findAccessibleResources(
                organizationId,
                pageable
        );
    }

}