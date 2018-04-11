package com.example.demo.service.secondary;

import com.example.demo.domain.secondary.SodTransactionSecondary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SodTransactionService implements ISodTransactionService {
    @Autowired
    SodTransactionsRepositorySecondary sodTransactionsRepositorySecondary;

    @Override
    public List<SodTransactionSecondary> findByCardNumber(String cardNumber) {
        return sodTransactionsRepositorySecondary.findByCardNumberOrderByRegDateTimeDesc(cardNumber);
    }
}
