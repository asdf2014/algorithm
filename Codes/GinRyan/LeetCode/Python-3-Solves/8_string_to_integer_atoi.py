"""
请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42

示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。

示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
     因此返回 INT_MIN (−2^31) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/string-to-integer-atoi
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""

"""
解题思路：
这个题杂活比较多
首先我们需要一个O(N)去把所有数字和“-”负号拿出来，然后逐位为数字乘10并累加，最后
乘以符号，最后的最后判断范围，并限制为32位有符号整数。

这个题的用例比较恶心，测试了十多次才通过

"""


class Solution:
    def myAtoi(self, rawstr: str) -> int:
        # 截取掉所有空格
        # 剩下的开头只有可能是数字和符号了
        noSpaceRaw = rawstr.strip()
        INT_MAX = 2**31 - 1
        INT_MIN = -(2**31)

        # 长度为0 的直接返回0
        if len(noSpaceRaw) == 0:
            return 0

        fcn = noSpaceRaw[0]
        # 只要不是数字、+、-、空格开头一律返回0
        if (
            not (fcn >= "0" and fcn <= "9")
            and not fcn == "+"
            and not fcn == "-"
            and not fcn == " "
        ):
            return 0

        sign = 1  # 符号
        get_num = 0  # 结果数值

        # 从左往右遍历剩下的字符，遇到符号时便标记开始，标记为开始以后就只能遇到数字
        # 一旦遇到非数字，立即中止累加获取数字位置。
        start = False
        length = len(noSpaceRaw)
        if length == 1 and (noSpaceRaw[0] < "0" or noSpaceRaw[0] > "9"):
            return 0

        for i in range(length):

            if not start:
                if (
                    (noSpaceRaw[i] > "0" and noSpaceRaw[i] < "9")
                    or noSpaceRaw[i] == "-"
                    or noSpaceRaw[i] == "+"
                ):
                    # 当start = True以后，就再也不可以遇到非数字字符了
                    start = True

            # 判断不合法字符
            if i > 0 and (noSpaceRaw[i] < "0" or noSpaceRaw[i] > "9"):
                print("不符合条件字符：" + noSpaceRaw[i])
                break

            # 判断是不是紧跟着数字的'-'
            if (
                start
                and noSpaceRaw[i] == "-"
                and noSpaceRaw[i + 1] >= "0"
                and noSpaceRaw[i + 1] <= "9"
            ):
                sign = -1

            if start:
                if noSpaceRaw[i] >= "0" and noSpaceRaw[i] <= "9":
                    currentNum = ord(noSpaceRaw[i]) - 48
                    get_num = get_num * 10 + currentNum
                else:
                    pass
        # 乘以符号
        get_num *= sign

        if get_num > INT_MAX:
            get_num = INT_MAX
        elif get_num < -(2**31):
            get_num = INT_MIN
        return get_num


# testcase
print(Solution().myAtoi("0 123"))
print(Solution().myAtoi(" +3.1415926 "))
print(Solution().myAtoi("  -   3.1415926 "))
print(Solution().myAtoi("  -3.1415926 "))
print(Solution().myAtoi("-+2"))
print(Solution().myAtoi("+-2"))
print(Solution().myAtoi("  -0012a42"))
print(Solution().myAtoi("  12345678"))
print(Solution().myAtoi("  0000000000012345678"))
