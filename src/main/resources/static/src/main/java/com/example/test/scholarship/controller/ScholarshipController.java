package com.example.test.scholarship.controller;


import com.example.test.scholarship.domain.Scholarship;
import com.example.test.scholarship.dto.ScholarshipDTO;
import com.example.test.scholarship.service.ScholarshipService;
import com.example.test.utils.PaginationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/scholarship")
@Validated
public class ScholarshipController {


    private ScholarshipService scholarshipService;

    public ScholarshipController (ScholarshipService scholarshipService) {
        this.scholarshipService = scholarshipService;
    }


    @PostMapping
    public ResponseEntity<List<Scholarship>> createScholarship(@RequestHeader(name="userId") String userId,
                                                                               @RequestBody List<@Valid ScholarshipDTO> scholarshipDTOS) {
        return ResponseEntity.ok(scholarshipService.createScholarship(userId,scholarshipDTOS));
    }

    @PutMapping
    public ResponseEntity<List<Scholarship>> updateScholarship(@RequestBody List<@Valid ScholarshipDTO> scholarshipDTOS) {
        return ResponseEntity.ok(scholarshipService.updateScholarship(scholarshipDTOS));
    }


    @GetMapping
    public ResponseEntity<PaginationResponse<ScholarshipDTO>> getAllScholarship(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                                @RequestParam(value = "size", defaultValue = "10") int size,
                                                                                @RequestParam(value = "sort", defaultValue = "DESC") String sort,
                                                                                @RequestParam(value = "sortBy",defaultValue = "createdAt") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(sort),sortBy));
        return ResponseEntity.ok(scholarshipService.getScholarship(pageable));
    }

    @DeleteMapping("/{scholarshipId}")
    public Optional<Scholarship> deleteScholarship(@PathVariable String scholarshipId){
        return scholarshipService.deleteScholarship(scholarshipId);
    }
}
