package com.example.CompaniesData.convertor;

import com.example.CompaniesData.dto.ReportDto;
import com.example.CompaniesData.model.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReportMapper extends Mappable<Report , ReportDto> {
    @Mapping(target = "netProfit", source = "netProfit")
    Report toEntity(ReportDto reportDto);
    ReportDto toDto(Report report);
}
