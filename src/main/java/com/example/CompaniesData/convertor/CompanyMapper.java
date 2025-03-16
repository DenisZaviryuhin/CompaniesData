package com.example.CompaniesData.convertor;

import com.example.CompaniesData.dto.CompanyInfoDto;
import com.example.CompaniesData.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper extends Mappable<Company , CompanyInfoDto> {
    @Mapping(target = "id", source = "id")
    Company toEntity (CompanyInfoDto companyInfoDto);
    CompanyInfoDto toDto (Company company);


}
