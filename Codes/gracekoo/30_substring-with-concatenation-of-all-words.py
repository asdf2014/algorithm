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
        if len(words) == 0 or s == "":
            return []

        l_s = len(s)
        n = len(words)
        l_w = len(words[0])
        # 创建一个字典，存储words的单词和个数
        word_dic = {}
        for word in words:
            if word in word_dic.keys():
                word_dic[word] += 1
            else:
                word_dic[word] = 1

        res = []
        # 不同起点开始切片
        for i in range(l_w):
            cut_list = []
            start = i
            c_n = 0
            # 切词
            while l_s - start >= l_w:
                cut_list.append(s[start : start + l_w])
                c_n += 1
                start += l_w

            start_ind = 0
            while c_n - start_ind >= n:
                count = 0
                w_dic = {}
                # 遍历查找，直到匹配完成
                for w in cut_list[start_ind : start_ind + n]:
                    if w in word_dic.keys():
                        if w in w_dic.keys():
                            w_dic[w] += 1
                            if w_dic[w] > word_dic[w]:
                                break
                            count += 1
                        else:
                            w_dic[w] = 1
                            count += 1
                    else:
                        break
                if count == n:
                    res.append(i + start_ind * l_w)
                start_ind += 1

        return res


so = Solution()
print(so.findSubstring("barfoothefoobarman", ["foo", "bar"]))
