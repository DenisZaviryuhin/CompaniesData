package com.example.CompaniesData.controller;

import com.example.CompaniesData.convertor.CompanyMapper;
import com.example.CompaniesData.dto.CompanyDto;
import com.example.CompaniesData.dto.CompanyInfoDto;
import com.example.CompaniesData.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;


    @GetMapping
    public ResponseEntity<List<CompanyInfoDto>> getAllCompanies() {
        List<CompanyInfoDto> companyDtos = companyService.getAll();
        return ResponseEntity.ok().body(companyDtos);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyInfoDto> getCompanyById(@PathVariable("companyId") Long id) {
        CompanyInfoDto dto = companyService.getCompanyById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CompanyInfoDto> createCompany(@RequestBody CompanyInfoDto companyInfoDtoDto) {
        CompanyInfoDto dto = companyMapper.toDto(companyService.create(companyInfoDtoDto));
        return ResponseEntity.ok().body(dto);

    }
    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyInfoDto> updateCompany(@PathVariable Long id,
                                                        @RequestBody CompanyDto companyDto) {
        CompanyInfoDto dto = companyService.update(id, companyDto);
        return ResponseEntity.ok().body(dto);
    }



    @DeleteMapping("/{companyId}")
    public ResponseEntity<CompanyInfoDto> deleteCompany(@PathVariable("companyId") Long id) {
        CompanyInfoDto dto = companyService.delete(id);
        return ResponseEntity.ok().body(dto);
    }

}
