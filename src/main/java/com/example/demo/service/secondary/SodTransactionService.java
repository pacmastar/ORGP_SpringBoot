package com.example.demo.service.secondary;

import com.example.demo.domain.secondary.SodTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SodTransactionService implements ISodTransactionService {
    @Autowired
    SodTransactionsRepository sodTransactionsRepository;

    @Override
    public List<SodTransaction> findByCardNumber(String cardNumber) {
        return sodTransactionsRepository.findByCardNumberOrderByRegDateTimeDesc(cardNumber);
    }
}
