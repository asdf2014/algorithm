class MyQueue {
public:
    /** Initialize your data structure here. */
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        while(!s1_.empty()){
            s2_.push(s1_.top());
            s1_.pop();
        }
        s1_.push(x);
        while(!s2_.empty()){
            s1_.push(s2_.top());
            s2_.pop();
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int res = s1_.top();
        s1_.pop();
        return res;
    }
    
    /** Get the front element. */
    int peek() {
        return s1_.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return s1_.empty();
    }
private:
    stack<int> s1_;
    stack<int> s2_;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
