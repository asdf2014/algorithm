//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// getMin() -- Retrieve the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks. 
// 
// Related Topics Stack Design


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    private Stack<Integer> dataS;
    private Stack<Integer> minS;

    /** initialize your data structure here. */
    public MinStack() {
        dataS = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int x) {
        dataS.push(x);
        if (minS.empty()) {
            minS.push(x);
        } else {
            int minNum = minS.peek() < x ? minS.peek() : x;
            minS.push(minNum);
        }
    }
    
    public void pop() {
        if (!dataS.empty()) {
            dataS.pop();
            minS.pop();
        }
    }
    
    public int top() {
        if (!dataS.empty()) {
            return dataS.peek();
        }
        throw new RuntimeException("Empty Stack.");
    }
    
    public int getMin() {
        if (!dataS.empty()) {
            return minS.peek();
        }
        throw new RuntimeException("Empty Stack.");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
