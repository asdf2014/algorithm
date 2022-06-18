package com.yore.offer;

import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/7/1 16:17
 * @description
 */
public class Offer58_1 {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        s = s.replaceAll("\\s+", " ");
        String[] arr = s.split(" ");
        for (String s1 : arr) {
            st.push(s1);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
            sb.append(" ");
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1).trim();
        }
        return "";
    }

    public static void main(String[] args) {
        Offer58_1 o = new Offer58_1();
        System.out.println(o.reverseWords(" the sky    is        blue "));
    }
}
