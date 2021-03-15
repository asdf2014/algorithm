package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
class Solution0003 {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
			return 0;
		}
		int startIdx = 0;
		int endIdx = 0;
		int len = 1;
		Set<String> sets = new HashSet<String>();
		while(endIdx < s.length()) {
            sets.clear();
            String curCharSeq = s.substring(startIdx,endIdx+1);
            sets.addAll(Arrays.asList(s.substring(startIdx,endIdx+1).split("")));
            if(curCharSeq.length() == sets.size()) {
                len = sets.size();
            } else {
                startIdx++;
            }
            endIdx++;
		}
		if(endIdx - startIdx >len) {
			len = endIdx - startIdx;
		}
		return len;
    }
}