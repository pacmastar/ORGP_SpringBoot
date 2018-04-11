package com.example.demo.service.secondary;

import com.example.demo.domain.secondary.SodTransactionSecondary;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SodTransactionsRepositorySecondary extends JpaRepository<SodTransactionSecondary, Long>{

    List<SodTransactionSecondary> findByCardNumberOrderByRegDateTimeDesc(String cardNumber);

}
