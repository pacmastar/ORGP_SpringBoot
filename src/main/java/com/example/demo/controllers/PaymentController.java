package com.example.demo.controllers;

import com.example.demo.domain.primary.Payment;
import com.example.demo.service.ParserService;
import com.example.demo.service.primary.PaymentService;
import com.example.demo.service.secondary.SodTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    SodTransactionService sodTransactionService;

    @Autowired
    ParserService parserService;

    @RequestMapping("/")
    public String indexPage(){
        return "index";
    }

    @RequestMapping("/payments")
    public String doPaymentList(Model model){
        List<Payment> paymentList = new ArrayList<Payment>();
        model.addAttribute("paymentList", paymentService.findBlockedPayments());
        return "paymentList";
    }

    @RequestMapping("/payment/view/{tableid}")
    public String viewPayment(Model model, @PathVariable("tableid") Long tableid){
        Payment payment = paymentService.findByTableId(tableid);
        String cardNumber = payment.getCardNumber();
        model.addAttribute("payment", payment);
        model.addAttribute("sodTransactions", sodTransactionService.findByCardNumber(cardNumber));

        model.addAttribute("messages", parserService.findByUid(cardNumber, payment.getChangeStatusTime()));
        return "viewPayment";
    }

    @RequestMapping("/payment/changestatus/{tableid}")
    public String unblock(@PathVariable("tableid") Long tableid){
        Payment payment = paymentService.findByTableId(tableid);
        paymentService.unblockPayment(payment);
        return "redirect:/payment/view/{tableid}";
    }
}
