package com.example.neontask.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "resource_access_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceAccessRule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(
            name = "allowed_organization_id",
            nullable = false
    )
    private String allowedOrganizationId;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "resource_id",
            nullable = false
    )
    private Resource resource;

}