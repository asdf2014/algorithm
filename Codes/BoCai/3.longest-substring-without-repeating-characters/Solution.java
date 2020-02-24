/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length<=1) return length;
        byte[] bytes = s.getBytes();
        int[] mark = new int[128];
        int max = 0;
        int start = mark[(int)bytes[0]] = 1;
        length = 1;
        for(int i=1;i< bytes.length;){
            byte current = bytes[i];
            i++;
            if(mark[current]>=start){
                max = max>length?max:length;
                start = mark[current]+1;
                length = i-start+1;
            }else {
                length++;
                max = max>length?max:length;
            }
            mark[current] = i;
        }
        return max;
    }
}
// @lc code=end