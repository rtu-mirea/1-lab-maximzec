package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myRegexUsing {
    private static String regex = "(\\$[0-9,]+(\\.[0-9]{2})?)";
    private static Pattern pattern = Pattern.compile(regex);
    public static boolean isMatch(String price){
        return price.matches(regex);
    }

    public static String returnValue(String textWIthPrice){
        String[] prices = textWIthPrice.split(" ");
        StringBuffer newPrice = new StringBuffer();
        for (int i = 0; i < prices.length ; i++) {
            if(isMatch(prices[i])){
               newPrice.append(prices[i]).append(",");
            }
        }
        return newPrice.toString();
    }
}
