package com.sda.auction.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateConverter {

    private String datePattern = "yyyy-MM-dd";
    private String datePattern2 ="dd-MM-yyyy";

    public Date convertDate(String stringDate) {
        //schimbam tipul de data acuma
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        try {
            //asta va arunca o exceptie
            Date date = simpleDateFormat.parse(stringDate);
            return date;
        } catch (ParseException e) {
            return null;
        }

    }

    public String format(Date date ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern2);
        return dateFormat.format(date);

    }
}