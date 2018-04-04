package com.example.demo.aop;

import com.example.demo.domain.primary.Payment;
import com.example.demo.domain.secondary.PaymentBackup;
import com.example.demo.service.secondary.PaymentBackupRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.Pointcuts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect extends Pointcuts {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PaymentBackupRepository paymentBackupRepository;

    @Before(value = "execution(* com.example.demo.service.primary.PaymentService.unblockPayment(..)) && args(payment,..)")
    public void logBefore(JoinPoint joinPoint, Payment payment) {
        log.info("Payment object: " + payment.toString());
        PaymentBackup backup = new PaymentBackup(payment);
        backup.setUserName("iga");
        backup.setDescription("webApp");
        log.info("backup object: " + backup.toString());
        paymentBackupRepository.save(backup);
        log.info("stored");
    }
}
