package com.yore.offer;

import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/6/25 9:15
 * @description
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return popped.length == 0;
        }
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;
        st.push(pushed[i++]);
        while (i < pushed.length || !st.isEmpty()) {
            if (!st.isEmpty() && st.peek() == popped[j]) {
                j++;
                st.pop();
            } else {
                if (i >= pushed.length) {
                    return false;
                }
                st.push(pushed[i++]);
            }
        }
        return j == popped.length;
    }

    public static void main(String[] args) {
        Offer31 o = new Offer31();
        System.out.println(o.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
