package com.example.expenseCalculator.service;

import com.example.expenseCalculator.models.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public class APIResponseMapper {
    public ApiResponse createAPISuccessResponse(Object data){
        return ApiResponse.builder().result(data).build();
    }
}
