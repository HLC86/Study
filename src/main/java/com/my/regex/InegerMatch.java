package com.my.regex;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by U0149852 on 2014/7/26.
 */
public class InegerMatch {
    public static void main(String[] args){
        /*
        String s = "Hello world hello pattern in string split";

        //matches
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("1234".matches("^[0-9]+$"));
        System.out.println("+1234".matches("-?\\d+"));
        System.out.println("-1234".matches("(-|\\+)?\\d+"));
        System.out.println("@Helloaa.".matches("(([A-Z]+)?([a-z]+)?(\\W+)?){8,}"));//password

        //split
        System.out.println(Arrays.toString(s.split(" ")));
        System.out.println(Arrays.toString(s.split("\\W+")));
        System.out.println(Arrays.toString(s.split("n\\W+")));//n followed by non-word char
        System.out.println(Arrays.toString(s.split("n\\w+")));//n followed by word

        //replace
        System.out.println(s.replaceAll("n\\w+", "aaaa"));
        System.out.println(s.replaceAll("world|pattern", "aaaa"));

        //quantifiers
        System.out.println("a11ba1ba111b".matches(".*a(1+)b.*"));
        System.out.println("a11ba1ba111b".matches(".*a(1+?)b.*"));
        System.out.println("a11ba1ba111b".matches(".*a(1++)b.*"));

        Pattern p = Pattern.compile(".*a(1++)b.*");
        Matcher m = p.matcher("a11ba1ba111b");
       System.out.println(m.find());
       System.out.println(m.group(1));
       // System.out.println(m.group(2));

        //excersices
        System.out.println("Hello.".matches("^[A-Z].*.$"));//7
        System.out.println(Arrays.toString(s.split("hello|in")));//8
        System.out.println(s.replaceAll("a|e|i|o|u", "_"));//9
        System.out.println(s.replaceAll("[aeiou]", "_"));//9
*/

        //String s = "KI-datatrbcall";
        //System.out.println(Arrays.toString(s.split("\\s|[a-zA-Z]+")));
        //System.out.println(s.split("^(\\s|[a-zA-Z]+)").length);
//        Pattern p = Pattern.compile("KI-(.*?)(-product)*?");
//        Matcher m = p.matcher(s);
//        for(int i =0;m.find();i++){
//           System.out.println(m.group(1));
//        }
//        m.matches();
//        String g1 = null;
//        System.out.println("a"+g1);
        String filename="VTLocation_SDI.Incremental";
        String Rex="^(?!VTLocation_SDI\\.Incremental$|(.*\\.temp)$).*$";
        System.out.println(filename.matches(Rex));

        //fwd: http://blog.sina.com.cn/s/blog_72b1bc6a01014hnf.html
//        String reg="^(?!.*(不合谐)).*$";//用到了前瞻
//        System.out.println("不管信不信,反正现在很不合谐".matches(reg));//false不通过
//        System.out.println("不管信不信,反正现在非常合谐".matches(reg));//true通过
//        System.out.println("不合谐在某国是普遍存在的".matches(reg));//false不通过
//
//        reg="^.*(?<!(不合谐))$";//用到了后顾
//        System.out.println("不管信不信,反正现在很不合谐".matches(reg));//false不通过
//        System.out.println("不管信不信,反正现在非常合谐".matches(reg));//true通过
//        System.out.println("不合谐在某国是普遍存在的".matches(reg));//true通过
    }
}
