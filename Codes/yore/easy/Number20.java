package com.yore.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created on 2019/1/25
 *
 * @author jiabingwen
 */

public class Number20 {
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        char tmp;
        for (int i = 0; i < s.length(); i++) {
            tmp = s.charAt(i);
            if (set.contains(tmp)) {
                stack.push(tmp);
            } else {
                if (stack.empty() || tmp - stack.peek()  > 2 || tmp - stack.peek()  < 0) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size() == 0;
    }


}
