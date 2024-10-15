package com.example.test.scholarship.service.Impl;

import com.example.test.scholarship.domain.Scholarship;
import com.example.test.scholarship.domain.repository.ScholarshipRepository;
import com.example.test.scholarship.dto.ScholarshipDTO;
import com.example.test.scholarship.service.ScholarshipService;
import com.example.test.utils.PaginationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ScholarshipServiceImpl implements ScholarshipService {
    @Autowired
    private ScholarshipRepository scholarshipRepository;

    @Override
    public List<Scholarship> createScholarship(String userId, List<ScholarshipDTO> scholarshipDTOS) {
        List<Scholarship> toBeSaved = scholarshipDTOS.stream().map(scholarshipDTO -> new Scholarship(userId, scholarshipDTO))
                .collect(Collectors.toList());
        return scholarshipRepository.saveAll(toBeSaved);
    }

    @Override
    public List<Scholarship> updateScholarship(List<ScholarshipDTO> scholarshipDTOS) {
        Map<String, ScholarshipDTO> scholarshipDTOByIdMap = scholarshipDTOS.stream().collect(Collectors.toMap(ScholarshipDTO::getId, Function.identity()));
        List<Scholarship> allById = (List<Scholarship>) scholarshipRepository.findAllById(scholarshipDTOByIdMap.keySet());
        allById.forEach(scholarship -> {
            ScholarshipDTO scholarshipDTO = scholarshipDTOByIdMap.get(scholarship.getId());
            scholarship.updateScholarship(scholarshipDTO);
        });

        return scholarshipRepository.saveAll(allById);
    }

    @Override
    public PaginationResponse<ScholarshipDTO> getScholarship(Pageable pageable) {
        Page<Scholarship> page = scholarshipRepository.findAll(pageable);
        List<ScholarshipDTO> data = page.stream().map(ScholarshipDTO::new).collect(Collectors.toList());
        return new PaginationResponse<>(page.getNumber(), page.getTotalElements(), page.getTotalPages(), data);
    }

    @Override
    public Optional<Scholarship> deleteScholarship(String scholarshipId) {
        return scholarshipRepository.findById(scholarshipId);
    }

}
