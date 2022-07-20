package com.yore.medium;

import java.util.Stack;

/**
 * @author Yore
 * @date 2022/6/6 10:16
 * @description
 */
public class Interview0305 {
    class SortedStack {
        Stack<Integer> st;
        Stack<Integer> helper;

        public SortedStack() {
            this.st = new Stack();
            this.helper = new Stack();
        }

        public void push(int val) {
            if (this.st.isEmpty()) {
                this.st.push(val);
                return;
            }
            while (!this.st.isEmpty() && this.st.peek() < val) {
                this.helper.push(this.st.pop());
            }
            this.st.push(val);
            while (!this.helper.isEmpty()) {
                this.st.push(this.helper.pop());
            }
        }

        public void pop() {
            if (!st.isEmpty()) {
                this.st.pop();
            }
        }

        public int peek() {
            if (!st.isEmpty()) {
                return this.st.peek();
            }
            return -1;
        }

        public boolean isEmpty() {
            return this.st.isEmpty();
        }
    }

}
