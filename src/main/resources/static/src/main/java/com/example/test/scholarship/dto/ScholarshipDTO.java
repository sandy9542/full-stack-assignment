package com.example.test.scholarship.dto;

import com.example.test.scholarship.domain.Course;
import com.example.test.scholarship.domain.Scholarship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScholarshipDTO implements Serializable {
    private String id;
    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "course cannot be empty")
    private Course course;
    @NotNull(message = "concession cannot be empty")
    private Double concessionPercentage = 0.0;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Future(message = "validity must be a future date")
    private LocalDateTime validity;
    @NotEmpty(message = "description cannot be empty")
    private String description;
    @NotNull(message = "unlimited cannot be empty")
    private boolean unlimited;
    @NotNull(message = "usageThreshold cannot be empty")
    private Long usageThreshold = 0l;
    private Long usageCount = 0l;
    @NotNull(message = "active cannot be null")
    private boolean active;

    public ScholarshipDTO(Scholarship scholarship) {
        this.id = scholarship.getId();
        this.name = scholarship.getName();
        this.course = scholarship.getCourse();
        this.concessionPercentage = scholarship.getConcessionPercentage();
        this.validity = scholarship.getValidity();
        this.description = scholarship.getDescription();
        this.unlimited = scholarship.isUnlimited();
        this.usageThreshold = scholarship.getUsageThreshold();
        this.usageCount = scholarship.getUsageCount();

        this.active = scholarship.isActive() && !(LocalDate.now(ZoneId.of("Asia/Kolkata")).isAfter(scholarship.getValidity().toLocalDate()));
    }
}