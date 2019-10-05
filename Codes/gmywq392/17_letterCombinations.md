```python
class Solution(object):
    def letterCombinations(self, digits: str) -> list:
        dic = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        if len(digits) == 0:
            return []
        res = []
        for i in digits:
            temp = []
            di = int(i)
            for char in dic[di]:
                if not res:
                    temp.append(char)
                else:
                    for j in res:
                        temp.append(j + char)
            res = temp
        return res
```