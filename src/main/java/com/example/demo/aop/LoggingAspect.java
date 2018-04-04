package com.example.demo.aop;

import com.example.demo.domain.primary.Payment;
import com.example.demo.domain.secondary.PaymentBackup;
import com.example.demo.service.secondary.PaymentBackupRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.support.Pointcuts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect extends Pointcuts {

    @Autowired
    PaymentBackupRepository paymentBackupRepository;

    @Before(value = "execution(* com.example.demo.service.primary.PaymentService.unblockPayment(..)) && args(payment,..)")
    public void logBefore(JoinPoint joinPoint, Payment payment) {
        PaymentBackup backup = new PaymentBackup(payment);
        backup.setUserName("iga");
        backup.setDescription("webApp");
        System.out.println(backup);
        paymentBackupRepository.save(backup);
    }
}
