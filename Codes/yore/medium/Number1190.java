package com.yore.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/5/26 8:41
 * @description
 */
public class Number1190 {
    public static void main(String[] args) {
        Number1190 number = new Number1190();
        System.out.println(number.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
