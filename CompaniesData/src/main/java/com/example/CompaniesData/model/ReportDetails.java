package com.example.CompaniesData.model;

import com.example.CompaniesData.convertor.ListToJsonConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "report_details")
public class ReportDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Convert(converter = ListToJsonConverter.class)
    @Column(name = "financial_data", columnDefinition = "JSON")
    private List<String> financialData;
    @Column(name = "comments")
    private String comments;
    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;


}
