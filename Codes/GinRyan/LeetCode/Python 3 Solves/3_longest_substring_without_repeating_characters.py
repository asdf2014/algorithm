"""
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


"""

"""
 解题思考1:
 最通用的想法是，按照逐项进行比对是否存在重复项，来获取最长可能
 子串长度，如果这么做，那么妥妥的时间复杂度会是O(n^3).

 解题思考2：
 使用滑动窗口法，对字符串输入进行遍历。
 遍历过程中，将遇到的字母存入一个字典进行缓存，下次遇到时取出这个
 位置并赋值给窗口左边索引。很重要的一点是，不要忘记此时计数器要重
 置值，重置的值是两次重复字母之间的间隔，且窗口左边如果已经越过了
 这个重复字母前一次的出现的位置（窗口左边已经在上一次出现字母的右
 边），那么就以窗口左边和当前遍历所处的位置的差，就要成为计数器的
 重置起始值。

 右边索引将跟随遍历的递增索引值累加。
 此种方法不能忘记遍历结束后还要进行一次计数器判断赋值。大者胜
 出。

 这种做法的思想是，遇到重复字母后，事实上之前的部分滑动窗口都可以
 跳过判断了，只需要记录一下不重复子串长度即可，然后从最后一次重复
 的字母开始，把两次最相近的重复字母之间的字母数量加上以后重新计数
 节省了大量重复判断的时间。
 
 如果判断字母的唯一性缓存用列表存储：
 理论上它的时间复杂度大约为O(n^2)，如果牺牲空间换时间，用哈希映
 射或者说字典存储（字母：位置排序）的哈希表来存储正在检查的滑动
 窗口，可以替换一层查找过程的循环，查找过程从O(n)降低到约O(1)，
 整个滑动窗口比对的过程可以降低到O(n)。

 
 如果判断字母的唯一性缓存用哈希映射表/字典存储：
 利用字典/哈希映射和降低时间复杂度至O(n)，仅进行一次循环遍历。

 附加：
 是否可以将复杂度降至更低？比如将其降低至O(log n)？暂时没想到方法。
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # 最大长度子串
        maxSubStringLength = 0
        # 当前子串长度计数器
        counter = 0
        # 起始位置
        start = 0
        # 滑动位置
        end = 0

        cache = {}
        print("|char\t|start\t|end\t|index\t|count\t|duplicate\t|")
        for i in range(len(s)):
            currentChar = s[i]
            duplicated = currentChar in cache
            if not duplicated:
                # 当前字母不在缓存中时，窗口右边值可以和当前遍历索引相同
                # 并且将当前字母加入字典缓存，下次用于查询是否重复
                end = i
                cache[s[i]] = i
                # 计数器累加
                counter += 1

            else:
                # 发现重复字母！此时一个子串结束，判断是否为最长子串，如果是，
                # 赋值给最大长度子串值
                if maxSubStringLength < counter:
                    maxSubStringLength = counter

                if cache.get(s[i]) >= start:
                    # 此时开始进入下一个序列的计数
                    # 窗口左边值此时右跳，直接跳入重复字符的前一次出现的位置
                    start = cache.get(s[i])
                # 窗口右边值此时放到当前被判定为重复字母的位置上
                end = i

                # 这里十分关键。这里为了避免丢掉了两个重复字母中间可能非重复的部分，所以要把这部分
                # 作为计数器的起点
                counter = end - start
                cache[s[i]] = i

            if maxSubStringLength < counter:
                maxSubStringLength = counter

            #控制台展示每次便利时索引、滑动窗口、重复性判定等信息，仅调试
            print(
                "|"
                + currentChar
                + "\t|"
                + str(start)
                + "\t|"
                + str(end)
                + "\t|"
                + str(i)
                + "\t|"
                + str(counter)
                + "\t|"
                + str(duplicated)
                + "\t\t|"
            )
            
        return maxSubStringLength


print("--------------------------------------------------")
example = "qaazrrrrwgcewhsobke"  # 9
print(Solution().lengthOfLongestSubstring(example))
print("--------------------------------------------------")
example2 = "dvdf"  # 3
print(Solution().lengthOfLongestSubstring(example2))
print("--------------------------------------------------")
example3 = "ecdvdfxge"  # 6
print(Solution().lengthOfLongestSubstring(example3))
print("--------------------------------------------------")
example4 = "abcabcbb"  # 3
print(Solution().lengthOfLongestSubstring(example4))
print("--------------------------------------------------")
