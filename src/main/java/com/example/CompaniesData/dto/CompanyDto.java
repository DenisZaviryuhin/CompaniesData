package com.example.CompaniesData.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyDto {
    private Long id;
    private String companyName;
    private String registrationNumber;
    private String address;
}
