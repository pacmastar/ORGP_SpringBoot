package com.example.demo.controllers;


import com.example.demo.domain.primary.SodTransactionPrimary;
import com.example.demo.domain.secondary.SodTransactionSecondary;
import com.example.demo.service.primary.SodTransactionsRepositoryPrimary;
import com.example.demo.service.secondary.SodTransactionsRepositorySecondary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchSodController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired

    SodTransactionsRepositoryPrimary primaryRepository;

    @Autowired
    SodTransactionsRepositorySecondary secondaryRepository;

    @RequestMapping(value = "/searchSod", method = RequestMethod.GET)
    public String getForm(){
        log.info("GET: /searchSod");
        return "sodSearchForm";
    }


    @RequestMapping(value = "/searchSod", method = RequestMethod.POST)
    public String getPost(@RequestParam(value = "uid")String uid, Model model){
        log.info("POST: /searchSod");
        log.info("uid :" + uid);
        List<SodTransactionPrimary> primaryList = primaryRepository.findByCardNumberOrderByRegDateTimeDesc(uid);
        List<SodTransactionSecondary> secondaryList = secondaryRepository.findByCardNumberOrderByRegDateTimeDesc(uid);


        log.info("primary list size: " + primaryList.size());
        log.info("secondary list size: " + secondaryList.size());
        model.addAttribute("primaryList",primaryList);
        model.addAttribute("secondaryList",secondaryList);
        return "sodSearchForm";
    }
}
