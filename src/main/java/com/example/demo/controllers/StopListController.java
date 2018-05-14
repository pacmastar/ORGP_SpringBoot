package com.example.demo.controllers;

import com.example.demo.domain.primary.Payment;
import com.example.demo.domain.primary.StopListEntity;
import com.example.demo.service.primary.StopListEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class StopListController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StopListEntityRepository stopListEntityRepository;


    @RequestMapping(value = "/stoplist", method = RequestMethod.GET)
    public String getForm(){
        log.info("GET: /stoplist");
        return "stopListForm";
    }


    @RequestMapping(value = "/stoplist", method = RequestMethod.POST)
    public String getPost(@RequestParam(value = "uid")String uid, Model model){
        log.info("POST: /stoplist");
        log.info("uid :" + uid);
        List<StopListEntity> stopListEntities = stopListEntityRepository.getByUid(uid);
        log.info("list size: " + stopListEntities.size());
        model.addAttribute("cards",stopListEntities);
        return "stopListForm";
    }
    @RequestMapping(value = "/stoplist/delete/{uid}", method = RequestMethod.GET)
    public String removeByUid(@PathVariable("uid") String uid) {
        stopListEntityRepository.removeByUid(uid);
        log.info("remove from stoplist " + uid);
        return "redirect:/stoplist";
    }
}
