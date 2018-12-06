package com.zeljko.headlines2.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String manipulateDateFormat(String post_date){

        if(post_date == null)
            return "";

        if(post_date.equals("0001-01-01T00:00:00Z"))
            return "";

        SimpleDateFormat existingUTCFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date date = null;
        try {
            date = existingUTCFormat.parse(post_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return String.valueOf(date);
    }
}

