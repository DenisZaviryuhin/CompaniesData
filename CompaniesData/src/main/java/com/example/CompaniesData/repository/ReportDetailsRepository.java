package com.example.CompaniesData.repository;

import com.example.CompaniesData.model.ReportDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDetailsRepository extends JpaRepository<ReportDetails, Long> {
}
