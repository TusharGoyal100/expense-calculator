package com.example.expenseCalculator.controller;

import com.example.expenseCalculator.entity.Expense;
import com.example.expenseCalculator.models.ApiResponse;
import com.example.expenseCalculator.models.UpdateExpenseRequest;
import com.example.expenseCalculator.service.APIResponseMapper;
import com.example.expenseCalculator.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/expenses",produces = MediaType.APPLICATION_JSON_VALUE)
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    APIResponseMapper apiResponseMapper;

    @GetMapping
    public ResponseEntity<ApiResponse> getExpenseList(){
        List<Expense>expenses=expenseService.getExpenseList();

        return ResponseEntity.ok(apiResponseMapper.createAPISuccessResponse(expenses));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createExpense(@RequestBody UpdateExpenseRequest updateExpenseRequest){
        Expense expense=expenseService.createExpense(updateExpenseRequest);

        return ResponseEntity.ok(apiResponseMapper.createAPISuccessResponse(expense));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getExpenseListById(@PathVariable(name="id") String id){
        Expense expense=expenseService.getExpenseListById(id);

        return ResponseEntity.ok(apiResponseMapper.createAPISuccessResponse(expense));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateExpenseById(@PathVariable(name="id") String id, @RequestBody UpdateExpenseRequest updateExpenseRequest){
        Expense expense=expenseService.updateExpense(id,updateExpenseRequest);
        return ResponseEntity.ok(apiResponseMapper.createAPISuccessResponse(expense));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteExpenseById(@PathVariable(name="id") String id){
        expenseService.deleteExpenseById(id);
        return ResponseEntity.ok(apiResponseMapper.createAPISuccessResponse("Successfully deleted"));
    }

}
