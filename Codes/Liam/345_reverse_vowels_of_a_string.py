# 执行用时 : 180 ms
# 内存消耗 : 30.3 MB

# 方案：栈存放 遇到之后出栈


class Solution:
    def reverseVowels(self, s: str) -> str:
        vowel = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
        filter_word = [i for i in s if i in vowel]

        rst = list(s)
        for idx, ele in enumerate(rst):
            if ele in vowel:
                rst[idx] = filter_word.pop()

        return "".join(rst)
