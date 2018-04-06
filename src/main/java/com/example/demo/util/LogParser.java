package com.example.demo.util;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by mihailovis on 9/4/17.
 */
public class LogParser {

    public String parseDate(String testString) throws ParseException {
        String dateString = testString.substring(0, 23);
        DateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
        DateFormat outputFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");

        Date date = inputFormat.parse(dateString);
        return outputFormat.format(date);
    }

    public String parseMessage(String testString) {
        String result = testString.substring(55);
        return result;
    }

    public String convert(String message) throws UnsupportedEncodingException {
        message = StringUtils.strip(message);
        String hexString = message.replace("-", "");
        byte[] bytes = DatatypeConverter.parseHexBinary(hexString);
        String result = new String(bytes, "CP1251");
        return result;
    }

    public boolean isInformationLine(String message) {
        if (message.length() < 58) {
            return false;
        }

        String sign = message.substring(55, 58);


        if (sign.equals("1F-") || sign.equals("20-")) {
            return true;
        } else

            return false;
    }

    public String parseUID(String message) throws UnsupportedEncodingException {
        Pattern pattern = Pattern.compile("E0-20-B9-(.*?)-3C-42");
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            String uid = matcher.group(1).replace("-", "");
            uid = convert(uid);
            return uid;
        } else
            return "666";
    }

    public String cleanString(String message) {
        return message.replace("  ", "");
    }
}
