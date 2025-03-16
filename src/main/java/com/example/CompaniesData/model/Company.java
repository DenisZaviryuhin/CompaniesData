package com.example.CompaniesData.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String companyName;
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Report> reports;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

}
