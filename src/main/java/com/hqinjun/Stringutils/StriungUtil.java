package com.hqinjun.Stringtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StriungUtil {

    public static boolean stringForChinese(String string){
        int n = 0;
        for(int i = 0; i < string.length(); i++) {
            n = (int) string.charAt(i);
            if(!(19968 <= n && n <40869)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String string){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(string);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
//        System.out.println( isNumeric("78451234"));
//        System.out.println(stringForChinese("是你"));
    }
}
