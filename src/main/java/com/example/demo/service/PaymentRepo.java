package com.example.demo.service;

import com.example.demo.domain.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {
//        List<Payment> findByCardNumber(Payment payment, Pageable pageable);
    public Page<Payment> findByStatusEquals(int status, Pageable pageable);

    Payment findByTableId(Long tableId);
    }

