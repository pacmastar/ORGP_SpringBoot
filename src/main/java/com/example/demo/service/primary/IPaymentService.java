package com.example.demo.service.primary;

import com.example.demo.domain.primary.Payment;

import java.util.List;


public interface IPaymentService {
    void unblockPayment(Payment payment);
    List<Payment> findBlockedPayments();
    Payment findByTableId(long tableid);
}
