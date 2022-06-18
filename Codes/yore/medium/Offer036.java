package com.yore.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/1 8:27
 * @description
 */
public class Offer036 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String a = tokens[i];
            if (!"+".equals(a) && !"-".equals(a) && !"*".equals(a) && !"/".equals(a)) {
                queue.offerLast(Integer.valueOf(a));
            } else {
                int num2 = queue.pollLast();
                int num1 = queue.pollLast();
                if ("+".equals(a)) {
                    queue.offerLast(num1 + num2);
                } else if ("-".equals(a)) {
                    queue.offerLast(num1 - num2);
                } else if ("*".equals(a)) {
                    queue.offerLast(num1 * num2);
                } else if ("/".equals(a)) {
                    queue.offerLast(num1 / num2);
                }
            }
        }
        return queue.pollLast();
    }
}
