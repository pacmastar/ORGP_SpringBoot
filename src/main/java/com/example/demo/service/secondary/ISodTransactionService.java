package com.example.demo.service.secondary;

import com.example.demo.domain.secondary.SodTransaction;

import java.util.List;

public interface ISodTransactionService {
    List<SodTransaction> findByCardNumber(String cardNumber);

}
