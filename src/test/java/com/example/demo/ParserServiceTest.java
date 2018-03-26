package com.example.demo;

import com.example.demo.domain.secondary.SodTransaction;
import com.example.demo.util.LogProvider;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParserServiceTest {
    LogProvider logProvider = new LogProvider();

    @Test
    public void getListOfDirectories() throws ParseException {
//        т.к. логи не всегда лежат в соответсвующем каталоге искать следует в -1 и +1 день от даты блокировки
        String path = "\\\\192.168.6.111\\d$\\Server-metro-5.7.2.17\\LogDir\\BytesPort";
        Date changeStatusTime = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS").parse("20180106 15:32:08.123");
        List<String> expected = Arrays.asList("\\\\192.168.6.111\\d$\\Server-metro-5.7.2.17\\LogDir\\BytesPort\\BytesPort05.01.2018"
                , "\\\\192.168.6.111\\d$\\Server-metro-5.7.2.17\\LogDir\\BytesPort\\BytesPort06.01.2018"
                , "\\\\192.168.6.111\\d$\\Server-metro-5.7.2.17\\LogDir\\BytesPort\\BytesPort07.01.2018");
        List<String> actual = logProvider.ListOfDirectories(changeStatusTime);
        assertThat(actual, is(expected));


    }
}
