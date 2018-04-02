package com.example.demo.aop;

import com.example.demo.domain.primary.Payment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.support.Pointcuts;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect extends Pointcuts {
    @Before(value = "execution(* com.example.demo.service.primary.PaymentService.unblockPayment(..)) && args(payment,..)")
    public void logBefore(JoinPoint joinPoint, Payment payment){
        System.out.println("logBefore() is running!");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(payment.toString());
    }
}
