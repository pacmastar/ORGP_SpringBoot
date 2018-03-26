package com.example.demo.service;

import com.example.demo.domain.Message;

import java.util.List;

public interface IParserService {
    List<Message> findByUid(String uid, String date);
}
