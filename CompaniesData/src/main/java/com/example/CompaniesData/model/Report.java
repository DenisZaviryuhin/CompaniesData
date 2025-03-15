package com.example.CompaniesData.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "report_date")
    private LocalDateTime reportDate;
    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;
    @Column(name = "net_profit")
    private BigDecimal netProfit;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReportDetails> details;

    @PrePersist
    protected void onCreate(){
        reportDate = LocalDateTime.now();
    }
}
