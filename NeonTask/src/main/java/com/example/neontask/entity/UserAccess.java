package com.example.neontask.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_access")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String organizationId;
    @Column(nullable = false)
    private Integer clearanceLevel;
}
