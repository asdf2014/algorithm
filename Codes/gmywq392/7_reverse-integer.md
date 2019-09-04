```python
class Solution:
    def reverse(self, x: int) -> int:
        x = str(x)
        if x[0] == '-':
            x = x[1:]
            new_x = '-' + x[::-1]
        else:
            new_x = x[::-1]
        new_x = int(new_x)
        if new_x >= -2 ** 31 or new_x <= 2 ** 31 - 1:
            return new_x
        else:
            return 0
```