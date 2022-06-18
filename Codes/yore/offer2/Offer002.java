package com.yore.offer2;

import java.util.Stack;

/**
 * @author Yore
 * @date 2021/11/8 17:22
 * @description
 */
public class Offer002 {
    public String addBinary(String a, String b) {
        Stack<Integer> st = new Stack<>();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int c = 0;
        int index = 0;
        int sum = 0;
        while (index < a.length() && index < b.length()) {
            sum = a.charAt(index) - '0' + b.charAt(index) - '0' + c;
            c = sum >= 2 ? 1 : 0;
            st.push(sum % 2);
            index++;
        }
        while (index < a.length()) {
            sum = a.charAt(index) - '0' + c;
            c = sum >= 2 ? 1 : 0;
            st.push(sum % 2);
            index++;
        }
        while (index < b.length()) {
            sum = b.charAt(index) - '0' + c;
            c = sum >= 2 ? 1 : 0;
            st.push(sum % 2);
            index++;
        }
        StringBuilder sb = new StringBuilder();
        if(c==1){
            sb.append("1");
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }


    public String addBinary1(String a, String b) {
        int i = a.length() -1;
        int j = b.length() -1;
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int sum = 0;
        while(i>=0 || j>=0){
            sum+=c;
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
