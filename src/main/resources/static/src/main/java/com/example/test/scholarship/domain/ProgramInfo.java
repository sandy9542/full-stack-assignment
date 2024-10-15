package com.example.test.scholarship.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramInfo {
    private String programId;
    private String name;
    private List<Item> items = new ArrayList<>();
}
