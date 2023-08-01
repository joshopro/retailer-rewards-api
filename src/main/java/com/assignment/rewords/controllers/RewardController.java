package com.assignment.rewords.controllers;

import com.assignment.rewords.dto.TransactionDTO;
import com.assignment.rewords.models.Transaction;
import com.assignment.rewords.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardController {
    private static final Logger logger = LoggerFactory.getLogger(RewardController.class);

    @Autowired
    private RewardService service;

    @GetMapping("/{customerId}")
    public ResponseEntity<Integer> getRewardPoints(@PathVariable String customerId) {
        logger.info("Processing reward points request for customer {}", customerId);
        int points = service.calculateRewardPoints(customerId);
        return new ResponseEntity<>(points, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
        logger.info("Processing transaction creation request for customer {}", transactionDTO.getCustomerId());
        Transaction transaction = service.createTransaction(transactionDTO);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/transactions/{customerId}")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String customerId) {
        logger.info("Processing transaction fetch request for customer {}", customerId);
        List<Transaction> transactions = service.getTransactions(customerId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}