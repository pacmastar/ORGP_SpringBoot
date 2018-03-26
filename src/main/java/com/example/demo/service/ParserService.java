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

@Service
public class ParserService implements IParserService {


    @Override
    public List<Message> findByUid(String uid, Date date) {
        LogProvider logProvider = new LogProvider();
        LogParser logParser = new LogParser();
        List<Message> messageList = new ArrayList<>();
        List<File> files = logProvider.fileListOfDirectories(date);
        for (File file : files) {
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
                        System.out.println(logParser.parseUID(line));
                        if (uid.equals(logParser.parseUID(line))) {
                            String regDateTime = logParser.parseDate(line);
                            String info = logParser.convert(logParser.parseMessage(line));
                            messageList.add(new Message(uid, regDateTime, info));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return messageList;
    }
}