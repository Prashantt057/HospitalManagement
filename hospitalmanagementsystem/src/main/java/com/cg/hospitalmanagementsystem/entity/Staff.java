package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {

    @Id
    @Column(name = "staffId")
    private Integer staffId;

    @Column(name = "staffEmail", nullable = false, unique = true)
    private String staffEmail;

    @Column(name = "staffPassword", nullable = false)
    private String staffPassword;

    @Column(name = "role")
    private String role;
}

