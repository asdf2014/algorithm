package com.yore.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/4/26 9:58
 * @description
 */
public class Number155 {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
            this.minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            this.stack.push(val);
            this.minStack.push(Math.min(this.minStack.peek(), val));
        }

        public void pop() {
            this.stack.pop();
            this.minStack.pop();
        }

        public int top() {
            return this.stack.peek();
        }

        public int getMin() {
            return this.minStack.peek();
        }
    }

}
