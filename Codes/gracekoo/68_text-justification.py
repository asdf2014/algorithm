# -*- coding: utf-8 -*-
# @Time: 2020/3/9 19:20
# @Author: GraceKoo
# @File: 68_text-justification.py
# @Desc:https://leetcode-cn.com/problems/text-justification/
from typing import List


class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        if not words:
            return []
        result = []
        current_chars_number = 0  # 当前行存储的字符个数(不包括空格)
        current_words_number = 0  # 当前行存储的单词个数，用于统计
        word_list = []  # 当前行的单词列表
        for index, value in enumerate(words):
            current_word_length = len(value)
            # 当前字符数量大于最大限制
            if (
                current_chars_number + current_word_length + current_words_number
                > maxWidth
            ):
                if current_words_number == 1:
                    result.append(
                        word_list[0] + " " * (maxWidth - current_chars_number)
                    )
                else:
                    blank_space_number = (
                        maxWidth - current_chars_number
                    )  # 当前的空格数量
                    if (
                        blank_space_number % (current_words_number - 1) == 0
                    ):  # 空格可以平均分配
                        result.append(
                            (
                                " " * (blank_space_number // (current_words_number - 1))
                            ).join(word_list)
                        )
                    else:
                        # 空格不能平均分配
                        more_blankspace = blank_space_number % (
                            current_words_number - 1
                        )  # 多余的空格
                        stand_blankspace = blank_space_number // (
                            current_words_number - 1
                        )  # 标准的最少空格
                        res = word_list[0]
                        for i in range(more_blankspace):
                            res += " " * (stand_blankspace + 1) + word_list[i + 1]
                        for i in range(more_blankspace + 1, len(word_list)):
                            res += " " * stand_blankspace + word_list[i]
                        result.append(res)
                current_chars_number = current_word_length
                current_words_number = 1
                word_list = [value]
            else:
                current_chars_number += current_word_length
                current_words_number += 1
                word_list.append(value)
        return result


so = Solution()
print(
    so.fullJustify(["This", "is", "an", "example", "of", "text", "justification."], 16)
)
