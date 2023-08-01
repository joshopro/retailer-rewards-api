package com.assignment.rewords.dto;

import java.time.LocalDate;

public class TransactionDTO {
    private String customerId;
    private Double amount;
    private LocalDate dateOfTransaction;

//    public TransactionDTO(String customerId, Double amount, LocalDate dateOfTransaction) {
//        this.customerId = customerId;
//        this.amount = amount;
//        this.dateOfTransaction = dateOfTransaction;
//    }
//
//    public TransactionDTO() {
//    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(LocalDate dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

}