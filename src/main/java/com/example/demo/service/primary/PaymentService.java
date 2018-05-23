package com.example.demo.service.primary;

import com.example.demo.domain.primary.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public void unblockPayment(Payment payment) {
        payment.setStatus(0);
        paymentRepository.save(payment);
        log.info(payment.getCardNumber() + "set status 0");
    }

    @Override
    public void layAsidePayment(Payment payment) {
        payment.setStatus(42);
        paymentRepository.save(payment);
        log.info(payment.getCardNumber() + "set status 42");
    }

    @Override
    public void repaidPayment(Payment payment) {
       payment.setStatus(51);
       paymentRepository.save(payment);
        log.info(payment.getCardNumber() + "set status 51");
    }


    @Override
    public List<Payment> findBlockedPayments() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
             date = simpleDateFormat.parse("2018-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return paymentRepository.findByStatusEqualsAndAgentTimeAfterOrderByAgentTimeDesc(61,date);
    }

    @Override
    public List<Payment> findLayAsidePayments() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse("2018-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return paymentRepository.findByStatusEqualsAndAgentTimeAfterOrderByAgentTimeDesc(42,date);
    }


    @Override
    public Payment findByTableId(long tableid) {
        return paymentRepository.findByTableId(tableid);
    }

    @Override
    public List<Payment> findByUid(String uid) {
        return paymentRepository.findByCardNumberOrderByTableIdDesc(uid);
    }

    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
