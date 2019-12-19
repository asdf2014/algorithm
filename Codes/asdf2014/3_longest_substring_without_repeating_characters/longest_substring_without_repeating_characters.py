# https://leetcode.com/problems/longest-substring-without-repeating-characters/

# Given a string, find the length of the longest substring without repeating characters.
#
# Example 1:
# Input: "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3.
#
# Example 2:
# Input: "bbbbb"
# Output: 1
# Explanation: The answer is "b", with the length of 1.
#
# Example 3:
# Input: "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3.
#             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
#
# Related Topics Hash Table Two Pointers String Sliding Window


def longest_substring_without_repeating_characters(s):
    begin = 0
    res = 0
    cache = {}
    # 遍历字符串
    for i, c in enumerate(s):
        # 如果当前字符 c 存在于 cache 中
        # 且 begin 指针小于等于 cache 中记录的字符下标（说明重复的字符 c，在当前记录的这条"不重复的字符串"中）
        if c in cache and begin <= cache[c]:
            # 则将 begin 指针重置为当前下标，并 +1
            begin = cache[c] + 1
        else:
            # 否则，计算当前记录的这条"不重复的字符串"的长度，并和历史最长记录比较
            res = max(res, i - begin + 1)
        # 将字符 c 下标缓存到 cache 中（用于记录字符 c 最后一次出现的下标位置）
        cache[c] = i
    return res


assert longest_substring_without_repeating_characters("") == 0
assert longest_substring_without_repeating_characters(" ") == 1
assert longest_substring_without_repeating_characters("au") == 2
assert longest_substring_without_repeating_characters("abcabcbb") == 3
assert longest_substring_without_repeating_characters("bbbbb") == 1
assert longest_substring_without_repeating_characters("pwwkew") == 3
# cache: {'y': 0, 'u': 5, 'z': 2, 'h': 3, 'o': 11, 'w': 6, 'a': 7, 'n': 8, '.': 9, 'c': 10, 'm': 12}
assert longest_substring_without_repeating_characters("yuzhouwan.com") == 9
