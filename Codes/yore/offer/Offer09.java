package com.yore.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jia bing wen
 * @date 2021/6/2 8:21
 * @description
 */
public class Offer09 {


    class CQueue {

        Deque<Integer> stack;
        Deque<Integer> stackTmp;


        public CQueue() {
            this.stack = new LinkedList<>();
            this.stackTmp = new LinkedList<>();
        }

        public void appendTail(int value) {
            while (!stack.isEmpty()) {
                stackTmp.push(stack.pop());
            }
            stack.push(value);
            while (!stackTmp.isEmpty()) {
                stack.push(stackTmp.pop());
            }
        }

        public int deleteHead() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.pop();
        }
    }
}
