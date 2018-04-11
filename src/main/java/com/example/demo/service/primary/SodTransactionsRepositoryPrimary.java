package com.example.demo.service.primary;

import com.example.demo.domain.primary.SodTransactionPrimary;
import com.example.demo.domain.secondary.SodTransactionSecondary;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
public interface SodTransactionsRepositoryPrimary extends JpaRepository<SodTransactionPrimary, Long>{

    List<SodTransactionPrimary> findByCardNumberOrderByRegDateTimeDesc(String cardNumber);

}
