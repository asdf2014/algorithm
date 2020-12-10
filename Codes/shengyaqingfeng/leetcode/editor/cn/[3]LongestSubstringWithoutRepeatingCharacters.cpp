//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4675 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int longer = 0;
        const char *ss = s.c_str();
        for (int index = 0; index < s.size(); index++)
        {
            vector<char> chs(0);
            for (int now = index; now < s.size(); now++)
            {
                bool b = false;
                for (char ch : chs)
                {
                    if (ch == ss[now])
                    {
                        b = true;
                    }
                }
                if (b)
                {
                    break;
                } else
                {
                    chs.push_back(ss[now]);
                }
            }
            longer = longer > chs.size() ? longer : chs.size();
        }
        return longer;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
