```python
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        div = 1
        while (x // div >= 10):
            div = div * 10
        while (x > 0):
            left = x // div
            right = x % 10
            if left != right:
                return False
            x = (x % div) // 10
            div = div // 100
        return True
```

```python
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        reverseNum = 0
        while (x > reverseNum):
            reverseNum = reverseNum * 10 + x % 10
            x = x // 10
        return x == reverseNum or x == reverseNum // 10
```