package com.example.demo.service.primary;

import com.example.demo.domain.primary.Payment;

import java.util.List;


public interface IPaymentService {
    void unblockPayment(Payment payment);
    void layAsidePayment(Payment payment);
    void repaidPayment(Payment payment);
    List<Payment> findBlockedPayments();
    List<Payment> findLayAsidePayments();
    Payment findByTableId(long tableid);
}
