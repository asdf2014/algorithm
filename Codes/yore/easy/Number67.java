package com.yore.easy;

/**
 * @author Yore
 * @date 2021/11/8 19:05
 * @description
 */
public class Number67 {
    public String addBinary(String a, String b) {
        int i = a.length() -1;
        int j = b.length() -1;
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int sum = 0;
        while(i>=0 || j>=0){
            sum = c;
            if(i>=0){
                sum += a.charAt(i--) -'0';
            }
            if(j>=0){
                sum += b.charAt(j--) -'0';
            }
            c = sum /2;
            sb.append(sum%2);
        }
        if(c ==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
