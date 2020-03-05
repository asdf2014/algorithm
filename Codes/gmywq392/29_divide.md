```python
# Definition for singly-linked list.

class Solution:

    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == 0: return 0
        if divisor == 1:
            return dividend
        if divisor == -1:
            if dividend > ~(1 << 31) + 1:
                return -dividend
            else:
                return (1 << 31) - 1

        a = abs(dividend)
        b = abs(divisor)

        def div(a, b):
            if a < b: return 0
            count = 1
            tb = b
            while tb + tb < a:
                count += count
                tb += tb
            return count + div(a - tb, b)

        ans = div(a, b)

        if (dividend > 0 and divisor < 0) or (dividend < 0 and divisor > 0):
            return -ans
        else:
            return 1 << 31 - 1 if ans >= 1 << 31 else ans

if __name__ == '__main__':
    solution = Solution()
    print(solution.divide(-2147483648, -1))
```