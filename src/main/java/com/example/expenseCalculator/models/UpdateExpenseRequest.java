package com.example.expenseCalculator.models;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UpdateExpenseRequest {
    private BigDecimal amount;
    private String expenseType;
}
