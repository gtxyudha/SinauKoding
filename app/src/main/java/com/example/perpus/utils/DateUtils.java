package com.example.perpus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String converterToDateFromData(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yy");

        try {
            return format.format(date);
        } catch (Exception e){
            return null;
        }

    }
}
