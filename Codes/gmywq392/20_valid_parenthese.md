```python
class Solution:
    def isValid(self, s: str) -> bool:
        vec = []

        for i in s:
            if i == '[':
                vec.append(']')
            elif i == '(':
                vec.append(')')
            elif i == '{':
                vec.append('}')
            elif len(vec) == 0 or vec.pop() != i:
                return False

        return len(vec) == 0
```