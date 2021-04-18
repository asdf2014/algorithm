package com.leetcode;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import javax.print.attribute.standard.NumberUpSupported;

public class Solution0007 {
    public int reverse(int x) {
        String strX = String.valueOf(x);
        String sign = "";
        if(strX.startsWith("-")){
            sign = "-";
            strX = strX.substring(1);
        }
        String[] strArr = strX.split("");
        int head = 0;
        int tail = strArr.length - 1;
        while(head<tail) {
            String tmp = strArr[head];
            strArr[head] = strArr[tail];
            strArr[tail] = tmp;
            head++;
            tail--;
        }
        String reversedX = sign + String.join("",strArr);
        try{
            return Integer.parseInt(reversedX);
        } catch(NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution0007 instance = new Solution0007();
        System.out.println(instance.reverse(1463847402));
    }
}