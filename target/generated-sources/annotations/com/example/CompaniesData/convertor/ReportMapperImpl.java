package com.example.CompaniesData.convertor;

import com.example.CompaniesData.dto.ReportDetailsDto;
import com.example.CompaniesData.dto.ReportDto;
import com.example.CompaniesData.model.Report;
import com.example.CompaniesData.model.ReportDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T19:48:17+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public List<ReportDto> toDtos(List<Report> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ReportDto> list = new ArrayList<ReportDto>( entities.size() );
        for ( Report report : entities ) {
            list.add( toDto( report ) );
        }

        return list;
    }

    @Override
    public List<Report> toEntities(List<ReportDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Report> list = new ArrayList<Report>( dtos.size() );
        for ( ReportDto reportDto : dtos ) {
            list.add( toEntity( reportDto ) );
        }

        return list;
    }

    @Override
    public Report toEntity(ReportDto reportDto) {
        if ( reportDto == null ) {
            return null;
        }

        Report.ReportBuilder report = Report.builder();

        report.netProfit( reportDto.getNetProfit() );
        report.id( reportDto.getId() );
        report.reportDate( reportDto.getReportDate() );
        report.totalRevenue( reportDto.getTotalRevenue() );
        report.details( reportDetailsDtoListToReportDetailsList( reportDto.getDetails() ) );

        return report.build();
    }

    @Override
    public ReportDto toDto(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDto.ReportDtoBuilder reportDto = ReportDto.builder();

        reportDto.id( report.getId() );
        reportDto.reportDate( report.getReportDate() );
        reportDto.totalRevenue( report.getTotalRevenue() );
        reportDto.netProfit( report.getNetProfit() );
        reportDto.details( reportDetailsListToReportDetailsDtoList( report.getDetails() ) );

        return reportDto.build();
    }

    protected ReportDetails reportDetailsDtoToReportDetails(ReportDetailsDto reportDetailsDto) {
        if ( reportDetailsDto == null ) {
            return null;
        }

        ReportDetails reportDetails = new ReportDetails();

        reportDetails.setId( reportDetailsDto.getId() );
        List<String> list = reportDetailsDto.getFinancialData();
        if ( list != null ) {
            reportDetails.setFinancialData( new ArrayList<String>( list ) );
        }
        reportDetails.setComments( reportDetailsDto.getComments() );

        return reportDetails;
    }

    protected List<ReportDetails> reportDetailsDtoListToReportDetailsList(List<ReportDetailsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ReportDetails> list1 = new ArrayList<ReportDetails>( list.size() );
        for ( ReportDetailsDto reportDetailsDto : list ) {
            list1.add( reportDetailsDtoToReportDetails( reportDetailsDto ) );
        }

        return list1;
    }

    protected ReportDetailsDto reportDetailsToReportDetailsDto(ReportDetails reportDetails) {
        if ( reportDetails == null ) {
            return null;
        }

        ReportDetailsDto.ReportDetailsDtoBuilder reportDetailsDto = ReportDetailsDto.builder();

        reportDetailsDto.id( reportDetails.getId() );
        List<String> list = reportDetails.getFinancialData();
        if ( list != null ) {
            reportDetailsDto.financialData( new ArrayList<String>( list ) );
        }
        reportDetailsDto.comments( reportDetails.getComments() );

        return reportDetailsDto.build();
    }

    protected List<ReportDetailsDto> reportDetailsListToReportDetailsDtoList(List<ReportDetails> list) {
        if ( list == null ) {
            return null;
        }

        List<ReportDetailsDto> list1 = new ArrayList<ReportDetailsDto>( list.size() );
        for ( ReportDetails reportDetails : list ) {
            list1.add( reportDetailsToReportDetailsDto( reportDetails ) );
        }

        return list1;
    }
}
