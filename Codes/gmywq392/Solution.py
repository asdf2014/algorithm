import collections
import queue


class MaxQueue:

    def __init__(self):
        self.deque = collections.deque
        self.queue = queue.Queue()

    def max_value(self) -> int:
        return self.deque[0] if self.deque else -1

    def push_back(self, value: int) -> None:
        while self.deque and self.deque[-1] < value:
            self.deque.pop()
        self.deque.append(value)
        self.queue.put(value)


    def pop_front(self) -> int:
        if not self.deque:return -1
        ans = self.queue.get()
        if ans == self.deque[0]:
            self.deque.popleft()
        return ans


# Your MaxQueue object will be instantiated and called as such:
# obj = MaxQueue()
# param_1 = obj.max_value()
# obj.push_back(value)
# param_3 = obj.pop_front()


if __name__ == "__main__":
    obj = MaxQueue()
    param_1 = obj.max_value()
    print(param_1)
    obj.push_back(123)
    param_3 = obj.pop_front()
    print(param_3)
