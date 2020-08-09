//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics String Backtracking 
// 👍 4102 👎 425


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new LinkedList<>();
        recur("", digits, 0, map, res);
        return res;
    }

    private void recur(
        String s,
        String digits,
        int level,
        HashMap<Character, String> map,
        List<String> res) {
        // terminator
        if (level >= digits.length()) {
            res.add(s);
            return;
        };
        // process
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length();i++) {
            // drill down
            recur(s+ letters.charAt(i), digits, level + 1, map, res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
