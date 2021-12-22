package com.yore.easy;

import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/4/3 21:29
 * @description
 */
public class Number682 {
    public static void main(String[] args) {

    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int first = 0;
        int second = 0;

        for (int i = 0; i < ops.length; i++) {
            if ("C".equals(ops[i])) {
                stack.pop();
            } else if ("D".equals(ops[i])) {
                stack.push(2 * stack.peek());
            } else if ("+".equals(ops[i])) {
                first = stack.pop();
                second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            } else {
                stack.push(Integer.valueOf(ops[i]));
            }
        }
        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
