package com.yore.medium;

import java.util.Stack;

/**
 * @author Yore
 * @date 2021/11/7 19:18
 * @description
 */
public class Number1081 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()){
            count[c]--;
            if(inStack[c]){
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c){
                if(count[stack.peek()] == 0){
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
