package com.sunuping.generate;

public class Solution {
    public static Long myAutoNumber(String str) {
        //首先判断空值
        if (str == null) {
            return 0L;
        }
        //去掉空格的情况
        str = str.trim();
        if (str.length() == 0)
            return 0L;
        //正负数标志
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+')
            index++;
        else if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        //取得数字部分，遇到溢出和非数字退出
        Long number = 0L;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' && str.charAt(index) > '9') {
                break;
            }
            number = number * 10 + (str.charAt(index) - '0');
            if (number >= Long.MAX_VALUE)
                break;
        }
        if (number * sign <= Long.MIN_VALUE)
            return Long.MIN_VALUE;
        if (number * sign >= Long.MAX_VALUE)
            return Long.MAX_VALUE;
        return number * sign;
    }
}