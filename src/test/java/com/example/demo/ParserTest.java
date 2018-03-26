package com.example.demo;

import com.example.demo.service.LogParser;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mihailovis on 9/4/17.
 */

public class ParserTest {
    LogParser logParser = new LogParser();
    @Test
    public void getDate() throws ParseException {

        String testString = "28.08.2017 14:05:30.334  >>  192.168.1.10: Отправлено: 03-04-99-30-7A-D4-2F-80-00-09-00   ";
        String date = logParser.parseDate(testString);
        assertEquals("20170828 14:05:30.334",date);
    }

    @Test
    public void getMessage(){
        String testString = "28.08.2017 14:05:30.334  >>  192.168.1.10: Отправлено: 03-04-99-30-7A-D4-2F-80-00-09-00   ";
        String message = logParser.parseMessage(testString);
        assertEquals(message,"03-04-99-30-7A-D4-2F-80-00-09-00   ");
    }

    @Test
    public void convert() throws UnsupportedEncodingException {
        String message = "DD-EB-E5-EA-F2-F0-EE-ED-ED-FB-E9-20-EA-EE-F8-E5-EB-B8-EA  ";
        String convertMessage = logParser.convert(message);
        assertEquals("Электронный кошелёк",convertMessage);
    }

    @Test
    public void isInformationLineTestTrue(){
        String message = "28.08.2017 14:05:42.393  >>  192.168.1.10: Отправлено: 1F-04-0E-2A-12-B7-3A-80-00-00-00-03-00-08-00-01-00-00-00-00-00-00-00-00-00-DD-EB-E5-EA-F2-F0-EE-ED-ED-FB-E9-20-EA-EE-F8-E5";
        boolean expected = logParser.isInformationLine(message);
        assertTrue(expected);
    }

    @Test
    public void isInformationLineTestFalse(){
        String message = "28.08.2017 14:05:42.393  >>  192.168.1.10: Отправлено: FF-04-0E-2A-12-B7-3A-80-00-00-00-03-00-08-00-01-00-00-00-00-00-00-00-00-00-DD-EB-E5-EA-F2-F0-EE-ED-ED-FB-E9-20-EA-EE-F8-E5";
        boolean expected = logParser.isInformationLine(message);
        assertFalse(expected);
        message = "06.09.2017 16:09:29.476  >>  D1 01.11.2016    D2 01.11.2016    ED 31.10.2016";
        expected = logParser.isInformationLine(message);
        assertFalse(expected);
    }

    @Test
    public void getUidFromLineTest() throws UnsupportedEncodingException {
        String message = "02.03.2017 07:42:30.314  >>  192.168.1.10: Отправлено: 1F-04-3C-60-12-53-43-80-00-00-00-03-00-08-00-01-00-00-00-00-00-00-00-00-00-DD-EB-E5-EA-F2-F0-EE-ED-ED-FB-E9-20-EA-EE-F8-E5-EB-B8-EA-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-20-00-00-00-00-00-00-00-00-00-00-00-00-00-00-01-00-00-00-A4-18-16-00-00-00-00-00-00-00-DD-EB-E5-EA-F2-F0-EE-ED-ED-FB-E9-20-EA-EE-F8-E5-EB-B8-EA-20-D0-E5-F1-F3-F0-F1-20-35-31-39-20-F0-F3-E1-2E-20-30-20-EA-EE-50-00-CA-E0-F0-F2-E0-20-B9-33-36-31-30-32-38-32-31-30-38-38-36-30-37-32-33-36-3C-42-52-3E-DD-EB-E5-EA-F2-F0-EE-ED-ED-FB-E9-20-EA-EE-F8-E5-EB-B8-EA-20-3C-42-52-3E-D0-E5-F1-F3-F0-F1-20-35-31-39-20-F0-F3-E1-2E-20-30-20-EA-EE-EF-2E-20-3C-42-52-3E-00";
        String expected = "36102821088607236";
        String uid = logParser.parseUID(message);
        assertEquals(uid,expected);
//
    }

    @Test
    public void cleanString(){
        String message = "Электронный кошелёк                                                                                               Электронный кошелёк Ресурс 519 руб. 0 коP Карта №36102821088607236<BR>Электронный кошелёк <BR>Ресурс 519 руб. 0 коп. <BR> ";
        String expected= "Электронный кошелёк Электронный кошелёк Ресурс 519 руб. 0 коP Карта №36102821088607236<BR>Электронный кошелёк <BR>Ресурс 519 руб. 0 коп. <BR> ";
        String result = logParser.cleanString(message);
        assertEquals(result,expected);


    }
}
