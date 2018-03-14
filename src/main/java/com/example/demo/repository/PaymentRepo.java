package com.example.demo.repository;

import com.example.demo.models.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,String> {
//        List<Payment> findByCardNumber(Payment payment, Pageable pageable);
    public Page<Payment> findByStatusEquals(int status, Pageable pageable);
    Payment findByTableId(Long tableId);
    }