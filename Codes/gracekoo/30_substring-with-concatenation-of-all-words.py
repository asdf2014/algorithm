# -*- coding: utf-8 -*-
# @Time: 2020/1/14 10:25 下午
# @Author: GraceKoo
# @File: 30_substring-with-concatenation-of-all-words.py
# @Desc:https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/


class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if len(s) == 0 or not words:
            return []

        words_number = len(words)
        words_len = len(words[0])
        s_len = len(s)

        # 将words中的单词与个数存储到字典中
        word_dic = {}
        for word in words:
            if word in word_dic.keys():
                word_dic[word] += 1
            else:
                word_dic[word] = 1

        output_list = []
        # 按照word的长度设三段切词的起点
        for i in range(words_len):
            # 将s按照word的长度截取words_number段
            start_index = i

            # 先对s进行切割
            s_cut_list = []
            cut_number = 0
            # 切词
<<<<<<< HEAD
            while l_s - start >= l_w:
                cut_list.append(s[start : start + l_w])
                c_n += 1
                start += l_w
=======
            while s_len - start_index >= words_len:
                s_cut_list.append(s[start_index:start_index + words_len])
                cut_number += 1
                start_index += words_len
>>>>>>> 708ddaf... fix bug of 30_substring-with-concatenation-of-all-words.py

            # 再对切割后的s进行判断，检验长度要求，个数要求
            start_cut_i = 0
            while cut_number - start_cut_i > words_number:
                # count记录当前已经匹配完成的个数
                count = 0
                w_dic = {}
<<<<<<< HEAD
                # 遍历查找，直到匹配完成
                for w in cut_list[start_ind : start_ind + n]:
                    if w in word_dic.keys():
                        if w in w_dic.keys():
                            w_dic[w] += 1
                            if w_dic[w] > word_dic[w]:
=======
                # 在s_cut_list中截取n个单词
                for s_word in s_cut_list[start_cut_i:start_cut_i + words_number]:
                    if s_word in word_dic.keys():
                        if s_word in w_dic.keys():
                            w_dic[s_word] += 1
                            if w_dic[s_word] > word_dic[s_word]:
>>>>>>> 708ddaf... fix bug of 30_substring-with-concatenation-of-all-words.py
                                break
                            count += 1
                        else:
                            w_dic[s_word] = 1
                            count += 1
                    else:
                        break
                if count == words_number:
                    output_list.append(i + start_cut_i * words_len)
                start_cut_i += 1

        return output_list


so = Solution()
print(so.findSubstring("barfoothefoobarman", ["foo", "bar"]))
