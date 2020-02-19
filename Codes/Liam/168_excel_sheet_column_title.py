# 执行用时 : 108 ms
# 内存消耗 : 29 MB

# 方案：按照二十六进制处理，做一个1-26:A-Z的字典

class Solution:
    def convertToTitle(self, n: int) -> str:
        # 按照二十六进制处理，做一个1-26:A-Z的字典
        my_dict = {
            1: "A",
            2: "B",
            3: "C",
            4: "D",
            5: "E",
            6: "F",
            7: "G",
            8: "H",
            9: "I",
            10: "J",
            11: "K",
            12: "L",
            13: "M",
            14: "N",
            15: "O",
            16: "P",
            17: "Q",
            18: "R",
            19: "S",
            20: "T",
            21: "U",
            22: "V",
            23: "W",
            24: "X",
            25: "Y",
            26: "Z",
        }

        rst = ""
        if n <= 0:
            return "wrong"
        else:
            while n / 26:
                num2 = n % 26 if n % 26 > 0 else 26
                rst = my_dict[num2] + rst
                n = int((n - num2) / 26)
            return rst
