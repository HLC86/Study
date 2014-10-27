package com.my.Types;

import oracle.sql.NUMBER;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Xiaoming Wang on 2014/10/23.
 */
public class OraTypes {
    public static void main(String[] args){
        Object o = "2";
        try {
            NUMBER n = new NUMBER("-3");
            System.out.println(n.bigDecimalValue().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            System.out.println(sDateFormat.parse("1900-01-01T00:00:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
