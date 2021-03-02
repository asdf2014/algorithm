# 24ms 13.5mb
# 40ms 13.5mb

# 方案：如下两种


class Solution:
    def findComplement(self, num: int) -> int:
        # 异或操作
        # 24ms 13.5mb
        # # if num=5(101), a=7(111)
        # a = 2**num.bit_length()-1
        # # return 2(010)
        # return num^a

        # 二进制翻转
        # 40ms 13.5mb
        # if num=5(101)
        rst = []
        for e in bin(num)[2:]:
            if e == "0":
                rst.append("1")
            else:
                rst.append("0")
        kk = "".join(rst)
        return int(kk, 2)
