class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs:
            return ""
        min_length = min([len(x) for x in strs])
        for l in range(0,min_length):
            for s in strs:
                if s[l]!=strs[0][l]:
                    return strs[0][:l]
        return strs[0][:min_length]
