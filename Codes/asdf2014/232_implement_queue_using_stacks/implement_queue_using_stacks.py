# https://leetcode.com/problems/implement-queue-using-stacks/


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
assert queue.pop() == 1
assert queue.empty()
queue.push(2)
assert queue.peek() == 2
assert not queue.empty()
queue.push(3)
assert queue.peek() == 2
assert not queue.empty()

queue = MyQueue()
queue.push(1)
queue.push(2)
assert queue.peek() == 1

queue = MyQueue()
queue.push(1)
queue.push(2)
assert queue.peek() == 1
assert queue.pop() == 1
assert not queue.empty()

queue = MyQueue()
queue.push(1)
queue.push(2)
assert queue.peek() == 1
assert queue.pop() == 1
assert queue.pop() == 2
assert queue.empty()
