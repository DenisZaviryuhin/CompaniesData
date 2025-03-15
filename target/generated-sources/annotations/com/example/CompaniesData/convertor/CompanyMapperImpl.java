package com.example.CompaniesData.convertor;

import com.example.CompaniesData.dto.CompanyInfoDto;
import com.example.CompaniesData.dto.ReportDetailsDto;
import com.example.CompaniesData.dto.ReportDto;
import com.example.CompaniesData.model.Company;
import com.example.CompaniesData.model.Report;
import com.example.CompaniesData.model.ReportDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-15T13:20:18+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public List<CompanyInfoDto> toDtos(List<Company> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CompanyInfoDto> list = new ArrayList<CompanyInfoDto>( entities.size() );
        for ( Company company : entities ) {
            list.add( toDto( company ) );
        }

        return list;
    }

    @Override
    public List<Company> toEntities(List<CompanyInfoDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Company> list = new ArrayList<Company>( dtos.size() );
        for ( CompanyInfoDto companyInfoDto : dtos ) {
            list.add( toEntity( companyInfoDto ) );
        }

        return list;
    }

    @Override
    public Company toEntity(CompanyInfoDto companyInfoDto) {
        if ( companyInfoDto == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.id( companyInfoDto.getId() );
        company.companyName( companyInfoDto.getCompanyName() );
        company.registrationNumber( companyInfoDto.getRegistrationNumber() );
        company.address( companyInfoDto.getAddress() );
        company.createdAt( companyInfoDto.getCreatedAt() );
        company.reports( reportDtoListToReportList( companyInfoDto.getReports() ) );

        return company.build();
    }

    @Override
    public CompanyInfoDto toDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyInfoDto.CompanyInfoDtoBuilder companyInfoDto = CompanyInfoDto.builder();

        companyInfoDto.id( company.getId() );
        companyInfoDto.companyName( company.getCompanyName() );
        companyInfoDto.registrationNumber( company.getRegistrationNumber() );
        companyInfoDto.address( company.getAddress() );
        companyInfoDto.createdAt( company.getCreatedAt() );
        companyInfoDto.reports( reportListToReportDtoList( company.getReports() ) );

        return companyInfoDto.build();
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

    protected Report reportDtoToReport(ReportDto reportDto) {
        if ( reportDto == null ) {
            return null;
        }

        Report.ReportBuilder report = Report.builder();

        report.id( reportDto.getId() );
        report.reportDate( reportDto.getReportDate() );
        report.totalRevenue( reportDto.getTotalRevenue() );
        report.netProfit( reportDto.getNetProfit() );
        report.details( reportDetailsDtoListToReportDetailsList( reportDto.getDetails() ) );

        return report.build();
    }

    protected List<Report> reportDtoListToReportList(List<ReportDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Report> list1 = new ArrayList<Report>( list.size() );
        for ( ReportDto reportDto : list ) {
            list1.add( reportDtoToReport( reportDto ) );
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

    protected ReportDto reportToReportDto(Report report) {
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

    protected List<ReportDto> reportListToReportDtoList(List<Report> list) {
        if ( list == null ) {
            return null;
        }

        List<ReportDto> list1 = new ArrayList<ReportDto>( list.size() );
        for ( Report report : list ) {
            list1.add( reportToReportDto( report ) );
        }

        return list1;
    }
}
