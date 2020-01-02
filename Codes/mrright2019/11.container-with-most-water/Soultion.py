class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        i,j = 0,len(height)-1
        res = 0
        if len(height)<=1:
            return -1
        while i<j:
            h = min([height[i], height[j]])
            res = max([(j-i) *h ,res])
            if height[i]>height[j]:
                j-=1
            else:
                i+=1
        return res 
