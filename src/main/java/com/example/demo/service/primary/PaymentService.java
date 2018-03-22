package com.example.demo.service.primary;

import com.example.demo.domain.Payment;

import java.util.List;


public interface PaymentService {
    void unblockPayment(Payment payment);
    List<Payment> findBlockedPayments();
    Payment findByTableId(long tableid);
}
