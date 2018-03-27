package com.example.demo.util;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogProvider {
    private List<String> dateList = new ArrayList<>();

    public  List<String> listOfDirectories(Date changeStatusTime) {
//        String path = "\\\\192.168.6.111\\d$\\Server-metro-5.7.2.17\\LogDir\\BytesPort\\BytesPort";
        String path = "d:\\bytePort\\BytesPort";

//        GregorianCalendar calendar = new GregorianCalendar();

//        calendar.setTime(changeStatusTime);
//        calendar.add(Calendar.DATE,-1);
//        dateList.add(path + new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()));
        dateList.add(path + new SimpleDateFormat("dd.MM.yyyy").format(changeStatusTime));

//        calendar.setTime(changeStatusTime);
//        calendar.add(Calendar.DATE,1);
//
//        dateList.add(path + new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()));
        return dateList;
    }

    public List<File> fileListOfDirectories(Date changeStatusTime){
        List<String> listOfDirectories = listOfDirectories(changeStatusTime);
        List<File> dirContents = new ArrayList<>();
        for (String element : listOfDirectories) {
            File[] files = new File(element).listFiles();
            System.out.println(files.length);
            for (File file : files) {
                dirContents.add(file);
            }
        }
        return dirContents;
    }
}
