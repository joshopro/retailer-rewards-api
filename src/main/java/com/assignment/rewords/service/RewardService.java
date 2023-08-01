package com.assignment.rewords.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.assignment.rewords.data.TransactionRepository;
import com.assignment.rewords.dto.TransactionDTO;
import com.assignment.rewords.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class RewardService {
    private static final Logger logger = LoggerFactory.getLogger(RewardService.class);

    @Autowired
    private TransactionRepository repository;

    @Transactional(readOnly = true)
    public int calculateRewardPoints(String customerId) {
        List<Transaction> transactions = repository.findByCustomerId(customerId);

        return transactions.stream()
                .mapToInt(this::calculatePointsForTransaction)
                .sum();
    }

    private int calculatePointsForTransaction(Transaction transaction) {
        double amount = transaction.getAmount();
        if (amount > 100) {
            return (int) ((amount - 100) * 2 + 50);
        } else if (amount > 50) {
            return (int) (amount - 50);
        } else {
            return 0;
        }
    }

    @Transactional
    public Transaction createTransaction(TransactionDTO transactionDTO) {
        logger.info("Creating transaction for customer {}", transactionDTO.getCustomerId());
        Transaction transaction = new Transaction();
        transaction.setCustomerId(transactionDTO.getCustomerId());
        transaction.setAmount(transactionDTO.getAmount());

        LocalDate localDate = transactionDTO.getDateOfTransaction();
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        transaction.setDateOfTransaction(date);

        return repository.save(transaction);
    }

    public List<Transaction> getTransactions(String customerId) {
        return repository.findByCustomerId(customerId);
    }
}