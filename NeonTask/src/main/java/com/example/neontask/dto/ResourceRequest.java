package com.example.neontask.dto;


import jakarta.validation.constraints.NotBlank;

public record ResourceRequest(
        @NotBlank(message = "Title is required")
        String title,
        @NotBlank(message = "Description is required")
        String description,
        @NotBlank(message = "OrganizationId is required")
        String organizationId

) {}