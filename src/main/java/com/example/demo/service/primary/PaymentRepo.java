package com.example.demo.service.primary;

import com.example.demo.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,String> {
    Payment findByTableId(Long tableId);
    List<Payment> findByStatusEqualsAndAgentTimeAfterOrderByAgentTimeDesc(int status, @Temporal(TemporalType.DATE) Date date);

}

