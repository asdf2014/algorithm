package com.leetcode;

public class Solution0005 {
	public String longestPalindrome(String s) {
		if (s.length() == 1) {
			return s;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			int left = 0;
			int right = s.length() - i - 1;
			while(right<=s.length() - 1) {
				String substr = s.substring(left, right + 1);
				if(isPalindrome(substr)) {
					return substr;
				}
				left++;
				right++;
			}
		}
		return s.substring(0, 1);
	}

	private boolean isPalindrome(String s) {
		if (s.length() == 1) {
			return true;
		}
		int left = s.length() / 2 - 1;
		int right = s.length() / 2 + 1;
		if (s.length() % 2 == 0) {
			right = s.length() / 2;
		}
		while (left >= 0) {
			if (s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			} else {
				return false;
			}
		}
		return true;
	}
}