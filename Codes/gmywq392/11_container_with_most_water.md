```python
class Solution(object):
    def maxArea(self, height: list) -> int:
        left, right, area = 0, len(height) - 1, 0
        while left < right:
            if height[left] < height[right]:
                area = max(area, height[left] * (right - left))
                left += 1
            else:
                area = max(area, height[right] * (right - left))
                right -= 1
        return area
```