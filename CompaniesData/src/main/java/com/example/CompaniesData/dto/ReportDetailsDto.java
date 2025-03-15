package com.example.CompaniesData.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReportDetailsDto {
    private Long id;
    private List<String> financialData;
    private String comments;


}
