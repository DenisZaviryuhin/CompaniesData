package com.example.CompaniesData.service;

import com.example.CompaniesData.convertor.CompanyMapper;
import com.example.CompaniesData.convertor.ReportMapper;
import com.example.CompaniesData.dto.CompanyDto;
import com.example.CompaniesData.dto.CompanyInfoDto;
import com.example.CompaniesData.dto.ReportDto;
import com.example.CompaniesData.model.Company;
import com.example.CompaniesData.model.Report;
import com.example.CompaniesData.repository.CompanyRepository;
import com.example.CompaniesData.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final ReportService reportService;
    private final ReportMapper reportMapper;
    private final ReportRepository reportRepository;

    public Company create(CompanyInfoDto companyDto) {
        Company company = companyMapper.toEntity(companyDto);
        companyRepository.save(company);
        return company;

    }

    public List<CompanyInfoDto> getAll() {
        List<Company> companies = companyRepository.findAll();
        if (companies.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        } else {
            return companies.stream()
                    .map(companyMapper::toDto)
                    .collect(Collectors.toList());
        }
    }


    public CompanyInfoDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No company with such id"));
        return companyMapper.toDto(company);

    }

    public CompanyInfoDto update(Long id, CompanyDto dto) {
        Company company = companyRepository.getReferenceById(id);
        if (!dto.getCompanyName().isEmpty()) {
            company.setCompanyName(dto.getCompanyName());
        }
        if (Objects.nonNull(dto.getRegistrationNumber())) {
            company.setRegistrationNumber(dto.getRegistrationNumber());

        }
        if (Objects.nonNull(dto.getAddress())) {
            company.setCompanyName(dto.getCompanyName());
        }
        return companyMapper.toDto(companyRepository.save(company));

    }

    public CompanyInfoDto delete(Long id) {
        Company company = companyRepository.getById(id);
        companyRepository.deleteById(id);
        return companyMapper.toDto(company);

    }
}
