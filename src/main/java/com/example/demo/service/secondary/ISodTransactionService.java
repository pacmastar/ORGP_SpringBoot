package com.example.demo.service.secondary;

import com.example.demo.domain.secondary.SodTransactionSecondary;

import java.util.List;

public interface ISodTransactionService {
    List<SodTransactionSecondary> findByCardNumber(String cardNumber);

}
