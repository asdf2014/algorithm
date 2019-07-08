- Problem link: [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- Language: C++


**Solution 1:**

```c++
// navie solution O(n^2)
// Status: Accepted
// Runtime: 864ms
// Memory: 249.8MB
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        if (s.empty()) return 0;
        map<char, int> char2index;
        char2index[s[0]] = 0;
        int cur = 1;
        int res = 1;
        for (int i = 1; i < s.length(); ++i) {
            auto iter = char2index.find(s[i]);
            if (iter == char2index.end()) {
                ++cur;
            } else {
                res = max(res, cur);
                int tmp = iter->second;
                cur = i - tmp;
                char2index.clear();
                for (int j = tmp + 1; j < i; ++j) {
                    char2index[s[j]] = j;
                }
            }
            char2index[s[i]] = i;
        }
        
        return max(res, cur);
    }
};
```

**Solution 2**:

```c++
// sliding window 滑动窗口
// Status: accepted
// Runtime: 12ms
// Memory: 10.9 MB
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        if (s.empty()) return 0;
        map<char, int> char2index;
        char2index[s[0]] = 0;
        size_t start = 0;
        size_t res = 1;
        size_t size =  s.size();
        for (size_t i = 1; i < size; ++i) {
            auto iter = char2index.find(s[i]);
            if (iter != char2index.end() && iter->second >= start) {
                start = iter->second + 1;
            }
            char2index[s[i]] = i;
            res = max(res, i - start+1);
        }
        
        return (int)res;
    }
};
```

**Solution 3:**

```c++
// 不使用map
// Status: accepted
// Runtime: 12ms
// Memory: 10.7MB
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n = s.size();
        if (n == 0) return 0;
        
        int start = -1;
        int res = 1;
        vector<int> m(256, -1);
        
        for (int i = 0; i < n; ++i) {
            if (m[s[i]] > start) {
                start = m[s[i]];
            }
            
            m[s[i]] = i;
            res = max(res, i - start);
        }
        
        return res;
    }
};
```
