package com.example.CompaniesData.convertor;

import com.example.CompaniesData.dto.ReportDetailsDto;
import com.example.CompaniesData.model.ReportDetails;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReportDetailsMapper extends Mappable<ReportDetails, ReportDetailsDto> {
    List<ReportDetailsDto> toDtos(List<ReportDetails> reportDetails);
    List<ReportDetails> toEntities(List<ReportDetailsDto> reportDetailsDtos);
}
