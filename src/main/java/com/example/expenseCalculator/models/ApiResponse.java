package com.example.expenseCalculator.models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private Object result;
}
