package com.example.expenseCalculator.repository;

import com.example.expenseCalculator.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    Optional<Expense>findById(Long id);

}
