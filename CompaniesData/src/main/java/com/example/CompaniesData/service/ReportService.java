package com.example.CompaniesData.service;

import com.example.CompaniesData.convertor.CompanyMapper;
import com.example.CompaniesData.convertor.ReportDetailsMapper;
import com.example.CompaniesData.convertor.ReportMapper;
import com.example.CompaniesData.dto.CompanyInfoDto;
import com.example.CompaniesData.dto.ReportDto;
import com.example.CompaniesData.model.*;
import com.example.CompaniesData.repository.CompanyRepository;
import com.example.CompaniesData.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final ReportDetailsMapper reportDetailsMapper;

    public CompanyInfoDto addReportToCompany(Long companyId, ReportDto reportDto) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found with id " + companyId));
        Report report = reportMapper.toEntity(reportDto);
        report.setCompany(company);
        for (ReportDetails details : report.getDetails()) {
            details.setReport(report);
        }
        reportRepository.save(report);
        company.getReports().add(report);
        companyRepository.save(company);
        return companyMapper.toDto(company);


    }
    public ReportDto getReportById(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("No report with such id"));
        return reportMapper.toDto(report);
    }

    public ReportDto updateReport(Long reportId, ReportDto reportDto) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("No report with such id"));
        if (Objects.nonNull(reportDto.getTotalRevenue())) {
            report.setTotalRevenue(reportDto.getTotalRevenue());
        }
        if (Objects.nonNull(reportDto.getNetProfit())) {
            report.setNetProfit(reportDto.getNetProfit());
        }
        List<ReportDetails> currentDetails = report.getDetails();

        if (Objects.nonNull(reportDto.getDetails())) {
            List<ReportDetails> newDetails = reportDetailsMapper.toEntities(reportDto.getDetails());
            for (ReportDetails current : currentDetails) {
                for (ReportDetails newDetail : newDetails) {
                    if (current.getId().equals(newDetail.getId())) {
                        if (Objects.nonNull(newDetail.getFinancialData())) {
                            current.setFinancialData(newDetail.getFinancialData());
                        }
                        if (Objects.nonNull(newDetail.getComments())) {
                            current.setComments(newDetail.getComments());
                        }
                    }
                }

            }
            report.setDetails(currentDetails);
        }
        return reportMapper.toDto(reportRepository.save(report));
    }

    public ReportDto delete(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("No report with such id"));
        reportRepository.deleteById(reportId);
        return reportMapper.toDto(report);

    }
}
