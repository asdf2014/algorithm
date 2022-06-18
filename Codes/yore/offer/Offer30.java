package com.yore.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jia bing wen
 * @date 2021/6/11 10:27
 * @description
 */
public class Offer30 {


    class MinStack {
        private Deque<Integer> stackA;
        private Deque<Integer> stackB;


        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.stackA = new LinkedList<>();
            this.stackB = new LinkedList<>();
        }

        public void push(int x) {
            stackA.push(x);
            if (stackB.size() == 0 || stackB.peek() >= x) {
                stackB.push(x);
            }
        }

        public void pop() {
            int d = stackA.pop();
            if (stackB.peek().equals(d)) {
                stackB.pop();
            }
        }

        public int top() {
            return stackA.peek();
        }

        public int min() {
            return stackB.peek();
        }
    }
}
