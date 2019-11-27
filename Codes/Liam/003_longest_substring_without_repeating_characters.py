#执行用时 : 92 ms
#内存消耗 : 12 MB

#方案：
# 简历字符key:频数value 字典，用value频数保证不重复
# 维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        #用字典存储所有出现字母
        freq = {}
        for key in set(s):
            freq[key] = 0
        
        # 左 右
        left, right = 0, -1
        result = 0

        #遍历
        while left < len(s):
            # 右边界在倒数第二个 且 右边不在字典
            if (right + 1 < len(s)) and (freq[s[right + 1]] == 0):
                # 右边界+1 
                right += 1
                # 右边界入字典
                freq[s[right]] += 1
            # 右边界已经到头 或者 右边元素在字典
            else: 
                # 左边出字典
                freq[s[left]] -= 1
                # 左边界右移
                left += 1
            # 每次更新一次结果：要么保持，要么取 左右边界跨距
            result = max(result, right- left + 1)

        return result
        
