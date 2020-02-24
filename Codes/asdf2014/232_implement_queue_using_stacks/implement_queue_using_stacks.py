# https://leetcode.com/problems/implement-queue-using-stacks/

# Implement the following operations of a queue using stacks.
#
# push(x) -- Push element x to the back of queue.
# pop() -- Removes the element from in front of queue.
# peek() -- Get the front element.
# empty() -- Return whether the queue is empty.
#
#
# Example:
# MyQueue queue = new MyQueue();
#
# queue.push(1);
# queue.push(2);
# queue.peek();  // returns 1
# queue.pop();   // returns 1
# queue.empty(); // returns false
#
# Notes:
# You must use only standard operations of a stack -- which means only push to top,
# peek/pop from top, size, and is empty operations are valid.
# Depending on your language, stack may not be supported natively.
# You may simulate a stack by using a list or deque (double-ended queue),
# as long as you use only standard operations of a stack.
# You may assume that all operations are valid
# (for example, no pop or peek operations will be called on an empty queue).
#
# Related Topics Stack Design


class MyQueue:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.in_stack, self.out_stack = [], []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.in_stack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.out_stack:
            in_stack_len = len(self.in_stack)
            count = 0
            while self.in_stack:
                count += 1
                if count == in_stack_len:
                    return self.in_stack.pop()
                self.out_stack.append(self.in_stack.pop())
        res = self.out_stack[-1]
        self.out_stack = self.out_stack[:-1]
        return res

    def peek(self) -> int:
        """
        Get the front element.
        """
        res = None
        if not self.out_stack:
            count = 0
            while self.in_stack:
                count += 1
                res = self.in_stack.pop()
                self.out_stack.append(res)
        else:
            res = self.out_stack[-1]
        return res

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.in_stack) == 0 and len(self.out_stack) == 0


# Your MyQueue object will be instantiated and called as such:
queue = MyQueue()
queue.push(1)
queue.push(2)
p = queue.peek()
assert p is 1

queue = MyQueue()
queue.push(1)
p = queue.pop()
assert p is 1
assert queue.empty()
queue.push(2)
p = queue.peek()
assert p is 2
assert not queue.empty()
queue.push(3)
p = queue.peek()
assert p is 2
assert not queue.empty()

queue = MyQueue()
queue.push(1)
queue.push(2)
p = queue.peek()
assert p is 1
p = queue.pop()
assert p is 1
assert not queue.empty()

queue = MyQueue()
queue.push(1)
queue.push(2)
p = queue.peek()
assert p is 1
p = queue.pop()
assert p is 1
p = queue.pop()
assert p is 2
assert queue.empty()
