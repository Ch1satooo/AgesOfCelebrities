package com.Ch1satooo.AgeOfCelebrities.utils.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatter {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + e);
        }
    }

    public static String formatDate(Date date) {
        if (date == null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        return simpleDateFormat.format(date);
    }

}
