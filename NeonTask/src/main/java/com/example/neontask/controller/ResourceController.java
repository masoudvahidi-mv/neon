package com.example.neontask.controller;

import com.example.neontask.dto.ResourceRequest;
import com.example.neontask.dto.ResourceResponse;
import com.example.neontask.service.ResourceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/resources")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @PostMapping
    public ResourceResponse create(
            @Valid
            @RequestBody ResourceRequest request) {

        return resourceService.create(request);
    }

    @GetMapping
    public Page<ResourceResponse> getResources(
            @AuthenticationPrincipal Jwt jwt,
            Pageable pageable) {

        return resourceService.getAccessibleResources(
                jwt,
                pageable
        );
    }

}