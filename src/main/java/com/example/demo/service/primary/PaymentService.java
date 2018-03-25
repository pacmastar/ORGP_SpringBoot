package com.example.demo.service.primary;

import com.example.demo.domain.primary.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public void unblockPayment(Payment payment) {
        payment.setStatus(0);
        paymentRepository.save(payment);
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
    public Payment findByTableId(long tableid) {
        return paymentRepository.findByTableId(tableid);
    }
}
