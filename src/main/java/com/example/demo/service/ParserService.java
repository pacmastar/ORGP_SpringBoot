package com.example.demo.service;

import com.example.demo.domain.Message;
import com.example.demo.util.LogParser;
import com.example.demo.util.LogProvider;
import org.springframework.stereotype.Service;


import javax.servlet.ServletRegistration;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ParserService implements IParserService {


    @Override
    public List<Message> findByUid(String uid, Date date) {
        LogProvider logProvider = new LogProvider();
        LogParser logParser = new LogParser();
        List<Message> messageList = new ArrayList<>();
        List<File> files = logProvider.fileListOfDirectories(date);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (File file : files) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    BufferedReader bufferedReader = null;
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    String line;
                    try {
                        while ((line = bufferedReader.readLine()) != null) {
                            if (logParser.isInformationLine(line)) {
                                if (uid.equals(logParser.parseUID(line))) {
                                    System.out.println(logParser.parseUID(line));
                                    String regDateTime = logParser.parseDate(line);
                                    String info = logParser.convert(logParser.parseMessage(line));
                                    messageList.add(new Message(uid, regDateTime, info));
                                }
                            }
                        }
                        System.out.println("thread: " + Thread.currentThread().getName() + "file " + file.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return messageList;
    }
}