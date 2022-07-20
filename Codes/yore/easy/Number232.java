package com.yore.easy;

import java.util.Stack;

/**
 * @author Yore
 * @date 2022/6/6 9:17
 * @description
 */
public class Number232 {
    class MyQueue {

        Stack<Integer> pushStack;
        Stack<Integer> popStack;

        public MyQueue() {
            this.pushStack = new Stack();
            this.popStack = new Stack();
        }

        public void push(int x) {
            this.pushStack.push(x);
        }

        public int pop() {
            if (!popStack.isEmpty()) {
                return popStack.pop();
            }
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.pop();
        }

        public int peek() {
            if (!popStack.isEmpty()) {
                return popStack.peek();
            }
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.peek();
        }

        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }
}
