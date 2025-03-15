package com.example.CompaniesData.controller;

import com.example.CompaniesData.dto.CompanyInfoDto;
import com.example.CompaniesData.dto.ReportDto;
import com.example.CompaniesData.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/{reportId}")
    public ResponseEntity<ReportDto> getReportById(@PathVariable("reportId") Long reportId) {
        ReportDto dto = reportService.getReportById(reportId);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<CompanyInfoDto> addReportToCompany(@PathVariable("companyId") Long companyId,
                                                             @RequestBody ReportDto reportDto) {
        CompanyInfoDto dto = reportService.addReportToCompany(companyId, reportDto);
        return ResponseEntity.ok().body(dto);

    }

    @PutMapping("/{reportId}")
    public ResponseEntity<ReportDto> updateReport(@PathVariable("reportId") Long reportId,
                                                  @RequestBody ReportDto reportDto) {
        ReportDto dto = reportService.updateReport(reportId, reportDto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<ReportDto> deleteReport(@PathVariable("reportId") Long reportId) {
        ReportDto reportDto = reportService.delete(reportId);
        return ResponseEntity.ok().body(reportDto);

    }
}
