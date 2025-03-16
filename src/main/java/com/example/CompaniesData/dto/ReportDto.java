package com.example.CompaniesData.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReportDto {
    private Long id;
    private LocalDateTime reportDate;
    private BigDecimal totalRevenue;
    private BigDecimal netProfit;
    private List<ReportDetailsDto> details = new ArrayList<>();

}
