package com.example.demo.service.secondary;

import com.example.demo.domain.primary.Payment;
import com.example.demo.domain.secondary.PaymentBackup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentBackupRepository extends JpaRepository<PaymentBackup,Long> {

}
