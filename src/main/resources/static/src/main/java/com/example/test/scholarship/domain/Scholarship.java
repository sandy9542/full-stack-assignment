package com.example.test.scholarship.domain;

import com.example.test.scholarship.dto.ScholarshipDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Scholarship implements Serializable {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private Course course;
    private Double concessionPercentage = 0.0;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime validity;
    private String description;
    private boolean unlimited;
    private Long usageThreshold = 0L;
    private Long usageCount = 0L;
    private boolean active;
    @JsonIgnore
    private String createdBy;
    private LocalDateTime createdAt = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    private LocalDateTime updatedAt;

    public Scholarship(String userId, ScholarshipDTO scholarshipDTO) {
        this.name = scholarshipDTO.getName();
        this.course = scholarshipDTO.getCourse();
        this.concessionPercentage = scholarshipDTO.getConcessionPercentage();
        this.validity = scholarshipDTO.getValidity();
        this.description = scholarshipDTO.getDescription();
        this.unlimited = scholarshipDTO.isUnlimited();
        this.usageThreshold = scholarshipDTO.getUsageThreshold();

        this.active = scholarshipDTO.isActive();
        this.createdBy = userId;
    }

    public void updateScholarship(ScholarshipDTO scholarshipDTO) {
        this.name = scholarshipDTO.getName();
        this.course = scholarshipDTO.getCourse();
        this.concessionPercentage = scholarshipDTO.getConcessionPercentage();
        this.validity = scholarshipDTO.getValidity();
        this.description = scholarshipDTO.getDescription();
        this.unlimited = scholarshipDTO.isUnlimited();
        this.usageThreshold = scholarshipDTO.getUsageThreshold();
        this.active = scholarshipDTO.isActive();
        this.usageCount = scholarshipDTO.getUsageCount();
        this.updatedAt = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    }

    public void applyScholarship() {
        this.usageCount++;
    }
}
