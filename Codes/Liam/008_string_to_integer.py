# 执行用时 : 32 ms
# 内存消耗 : 13 MB

# 方案：按照规则 简单解

class Solution:
    def myAtoi(self, str: str) -> int:
        str = str.lstrip(" ")
        result = ""
        
        # with "-" or "+"
        if str.startswith("-") or str.startswith("+"):
            result += str[0]
            str = str[1:]
            
        # add each number
        for each_num in str:
            if each_num in string.digits:
                result += each_num
            else:
                break
    
        num = result.lstrip("-+")

        if len(num) <= 0 or num[0] not in string.digits:
            return 0
        
        result = int(result)

        # upper bound
        if abs(result) > (2 ** 31 - 1):
            return -2 ** 31 if result < 0 else (2 ** 31 - 1)
        
        return result
