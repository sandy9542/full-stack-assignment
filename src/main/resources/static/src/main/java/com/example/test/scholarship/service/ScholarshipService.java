package com.example.test.scholarship.service;

import com.example.test.scholarship.domain.Scholarship;
import com.example.test.scholarship.dto.ScholarshipDTO;
import com.example.test.utils.PaginationResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface ScholarshipService {
    List<Scholarship> createScholarship(String userinfo, List<ScholarshipDTO> scholarshipDTOS);
    List<Scholarship> updateScholarship(List<ScholarshipDTO> scholarshipDTOS);
    PaginationResponse<ScholarshipDTO> getScholarship(Pageable pageable);
    Optional<Scholarship> deleteScholarship(String scholarshipId);
}
