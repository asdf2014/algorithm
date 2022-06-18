package com.yore.offer;

import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/7/8 9:12
 * @description
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root){
                return false;
            }
            while(!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
