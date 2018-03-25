package com.example.demo.service.secondary;

import com.example.demo.domain.secondary.SodTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SodTransactionsRepository extends JpaRepository<SodTransaction, Long>{

    List<SodTransaction> findByCardNumber(String cardNumber);

}
