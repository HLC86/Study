package com.my.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Xiaoming Wang on 2014/11/28.
 */
public class Patterns {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("http://cdm.ccchina.gov.cn/zyDetail.aspx\\?newsId=\\d+&TId=163");
        Matcher m = p.matcher("target=\"_blank\" href=\"http://cdm.ccchina.gov.cn/zyDetail.aspx?newsId=49408&TId=163\"");
        while (m.find()) {
            System.out.println("Match \"" + m.group() + "\" at positions " +
                    m.start() + "-" + (m.end() - 1));
        }

    }
}
