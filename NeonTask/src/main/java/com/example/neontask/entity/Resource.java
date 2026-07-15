package com.example.neontask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "resources")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resource {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;


    @Column(length = 10000)
    private String description;


    @Column(name = "organization_id", nullable = false)
    private String organizationId;


    @Column(name = "created_at")
    private LocalDateTime createdAt;



    @OneToMany(
            mappedBy = "resource",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<ResourceAccessRule> accessRules =
            new ArrayList<>();


    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
    }


    public void addAccessRule(ResourceAccessRule rule){

        accessRules.add(rule);
        rule.setResource(this);

    }

}