
```python
class Solution(object):
    def intToRoman(self, target: int) -> str:
        nums = {
            1: 'I',
            4: 'IV',
            5: 'V',
            9: 'IX',
            10: 'X',
            40: 'XL',
            50: 'L',
            90: 'XC',
            100: 'C',
            400: 'CD',
            500: 'D',
            900: 'CM',
            1000: 'M'
        }
        res = ''
        for k in sorted(nums.keys())[::-1]:
            digit = target // k
            if digit == 0:
                continue
            res += nums[k] * digit
            target -= digit * k
            if target == 0 :
                break
        return res
```