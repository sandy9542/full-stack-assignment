package com.example.test.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationResponse<T> implements Serializable
{
    private int currentPage;
    private Long totalItems = 0L;
    private int totalPages;
    private List<T> page = new ArrayList<>();

    public PaginationResponse(int currentPage, Long totalItems, int totalPages, List<T> data) {
        this.currentPage = currentPage;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.page = data;
    }
}
