//Given two strings s and t , write a function to determine if t is an anagram o
//f s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case? 
// Related Topics Hash Table Sort 
// 👍 1556 👎 143


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
//        return bf(s, t);
        return HashMap(s, t);


    }

    private boolean HashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];

        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();

        for (char ch : s_char) counter[ch - 'a']++;
        for (char ch : t_char) {
            counter[ch - 'a']--;
            if (counter[ch - 'a'] < 0) return false;
        }
//        for (int count : counter) {
//            if (count != 0) return false;
//        }

        return true;
    }

    private boolean bf(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        Arrays.sort(s_char);
        Arrays.sort(t_char);
        return Arrays.equals(s_char, t_char);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
