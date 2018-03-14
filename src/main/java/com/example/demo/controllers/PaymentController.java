package com.example.demo.controllers;

import com.example.demo.models.Payment;
import com.example.demo.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {

    @Autowired
    PaymentRepo paymentRepo;


    @RequestMapping("/payment/page/{page_num}")
    public String doPaymentList(Model model, @PathVariable(value = "page_num") int page_num){
//        model.addAttribute("paymentList",paymentRepo.findByStatusEquals(61));
//        return "paymentList";
        PageRequest pageRequest = new PageRequest(page_num,10);
        Page<Payment> allPayment = paymentRepo.findByStatusEquals(61,pageRequest);
        model.addAttribute("totalPage",allPayment.getTotalPages());
        model.addAttribute("page_num",page_num);
        model.addAttribute("paymentList",allPayment.getContent());

        return "paymentList";
    }

    @RequestMapping("/payment")
    public String paymentList(){
        return "redirect:/payment/page/1";
    }


    @RequestMapping("/payment/view/{tableid}")
    public String viewPayment(Model model, @PathVariable("tableid") Long tableid){
        model.addAttribute("payment",paymentRepo.findByTableId(tableid));
        return "viewPayment";
    }



    @RequestMapping("/payment/changestatus/{tableid}")
    public String unblock(@PathVariable("tableid") Long tableid){
        Payment payment = paymentRepo.findByTableId(tableid);
        payment.setStatus(0);
        paymentRepo.save(payment);
        return "redirect:/payment/view/{tableid}";
    }
}
