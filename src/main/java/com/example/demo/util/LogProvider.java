package com.example.demo.util;



import java.text.SimpleDateFormat;
import java.util.*;

public class LogProvider {
    public List<String> ListOfDirectories(Date changeStatusTime) {
        String path = "\\\\192.168.6.111\\d$\\Server-metro-5.7.2.17\\LogDir\\BytesPort\\BytesPort";

        List<String> dateList = new ArrayList<>();
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(changeStatusTime);
        calendar.add(Calendar.DATE,-1);
        dateList.add(path + new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()));
        dateList.add(path + new SimpleDateFormat("dd.MM.yyyy").format(changeStatusTime));

        calendar.setTime(changeStatusTime);
        calendar.add(Calendar.DATE,1);

        dateList.add(path + new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()));
        return dateList;
    }
}
