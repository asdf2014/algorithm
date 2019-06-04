package org.ginryan.github.leetcodes.s3_longest_substring_without_repeating_characters;

import java.util.HashMap;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int maxSubStringLength = 0;
		int counter = 0;
		int start = 0;
		int end = 0;
		HashMap<Character, Integer> cache = new HashMap<>();
		System.out.println("|char\t|start\t|end\t|index\t|count\t|duplicate\t|");
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			boolean duplicated = cache.containsKey(currentChar);
			if (!duplicated) {
				end = i;
				cache.put(currentChar, i);
				counter++;
			} else {
				if (maxSubStringLength < counter) {
					maxSubStringLength = counter;
				}
				if (cache.get(currentChar) >= start) {
					start = cache.get(currentChar);
				}
				end = i;
				counter = end - start;
				cache.put(currentChar, i);
			}
			if (maxSubStringLength < counter) {
				maxSubStringLength = counter;
			}
			System.out.println("|" + currentChar + "\t|" + start + "\t|" + end + "\t|" + i + "\t|" + counter + "\t|"
					+ duplicated + "\t\t|");
		}
		return maxSubStringLength;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("--------------------------------------------------");
		String example = "qaazrrrrwgcewhsobke"; // 9
		System.out.println(solution.lengthOfLongestSubstring(example));
		System.out.println("--------------------------------------------------");
		String example2 = "dvdf"; // 3
		System.out.println(solution.lengthOfLongestSubstring(example2));
		System.out.println("--------------------------------------------------");
		String example3 = "ecdvdfxge"; // 6
		System.out.println(solution.lengthOfLongestSubstring(example3));
		System.out.println("--------------------------------------------------");
		String example4 = "abcabcbb";// 3.
		System.out.println(solution.lengthOfLongestSubstring(example4));
		System.out.println("--------------------------------------------------");
	}
}