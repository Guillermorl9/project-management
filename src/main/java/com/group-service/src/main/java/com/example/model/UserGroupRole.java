package com.example.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGroupRole {

    @EmbeddedId
    private UserGroupRoleId id;

    @Enumerated(EnumType.STRING)
    private RoleApp role;
}
