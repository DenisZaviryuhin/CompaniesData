package com.example.CompaniesData.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyInfoDto {
    private Long id;
    private String companyName;
    private String registrationNumber;
    private String address;
    private LocalDateTime createdAt;
    private List<ReportDto> reports = new ArrayList<>();


}
