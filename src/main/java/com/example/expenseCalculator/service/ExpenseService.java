package com.example.expenseCalculator.service;


import com.example.expenseCalculator.entity.Expense;
import com.example.expenseCalculator.models.UpdateExpenseRequest;
import com.example.expenseCalculator.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public List<Expense> getExpenseList(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseListById(String id){
        return expenseRepository.findById(Long.parseLong(id)).get();
    }


    public Expense updateExpense(String id,UpdateExpenseRequest updateExpenseRequest){
       Expense expense= expenseRepository.findById(Long.parseLong(id)).get();
       expense.setExpenseType(updateExpenseRequest.getExpenseType());
       expense.setAmount(updateExpenseRequest.getAmount());
       return expenseRepository.save(expense);
    }

    public Expense createExpense(UpdateExpenseRequest updateExpenseRequest){
        Expense expense= Expense.builder()
                .time(LocalDateTime.now())
                .amount(updateExpenseRequest.getAmount())
                .expenseType(updateExpenseRequest.getExpenseType())
                .build();
        return expenseRepository.save(expense);
    }

    public void deleteExpenseById(String id){
        expenseRepository.deleteById(Long.parseLong(id));
        return ;
    }
}
