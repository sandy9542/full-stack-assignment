package com.example.test.scholarship.domain.repository;

import com.example.test.scholarship.domain.Scholarship;
import com.example.test.scholarship.dto.ScholarshipNameDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship,String> {}