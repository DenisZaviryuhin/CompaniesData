package com.example.CompaniesData.convertor;

import com.example.CompaniesData.dto.ReportDetailsDto;
import com.example.CompaniesData.model.ReportDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T19:47:22+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ReportDetailsMapperImpl implements ReportDetailsMapper {

    @Override
    public ReportDetailsDto toDto(ReportDetails entity) {
        if ( entity == null ) {
            return null;
        }

        ReportDetailsDto reportDetailsDto = new ReportDetailsDto();

        return reportDetailsDto;
    }

    @Override
    public ReportDetails toEntity(ReportDetailsDto dto) {
        if ( dto == null ) {
            return null;
        }

        ReportDetails reportDetails = new ReportDetails();

        return reportDetails;
    }

    @Override
    public List<ReportDetailsDto> toDtos(List<ReportDetails> reportDetails) {
        if ( reportDetails == null ) {
            return null;
        }

        List<ReportDetailsDto> list = new ArrayList<ReportDetailsDto>( reportDetails.size() );
        for ( ReportDetails reportDetails1 : reportDetails ) {
            list.add( toDto( reportDetails1 ) );
        }

        return list;
    }

    @Override
    public List<ReportDetails> toEntities(List<ReportDetailsDto> reportDetailsDtos) {
        if ( reportDetailsDtos == null ) {
            return null;
        }

        List<ReportDetails> list = new ArrayList<ReportDetails>( reportDetailsDtos.size() );
        for ( ReportDetailsDto reportDetailsDto : reportDetailsDtos ) {
            list.add( toEntity( reportDetailsDto ) );
        }

        return list;
    }
}
