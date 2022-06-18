# 执行用时 : 576 ms
# 内存消耗 : 28.9 MB

# 方案：字符串转数字


class Solution:
    def addStrings(self, a: str, b: str) -> str:
        # 字符串转数字的方法
        def str_to_num(strs):
            n = len(strs) - 1
            num = 0
            for i in strs:
                num += hash[i] * 10**n
                n -= 1
            return num

        # 直接调用即可
        hash = {
            "0": 0,
            "1": 1,
            "2": 2,
            "3": 3,
            "4": 4,
            "5": 5,
            "6": 6,
            "7": 7,
            "8": 8,
            "9": 9,
        }
        numa = str_to_num(a)
        numb = str_to_num(b)
        return str(numa + numb)
