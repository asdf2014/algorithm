```python

class Solution:

    def distributeCandies(self, candies: int, num_people: int) -> list:
        ans = [0] * num_people
        i = 0
        while candies != 0:
            ans[i % num_people] = min(i + 1, candies)
            candies -= min(i + 1, candies)
            i += 1
        return ans

```