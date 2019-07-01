- Problem Link: [Two-Sum](https://leetcode.com/problems/two-sum/)
- Language C++

**Solution 1:**
```c++
// Solution 1: O(n^2)暴力破解
// Status: Accept
// Runtime: 136 ms
// Memory: 9.2 MB
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> indices(2);
        size_t n = nums.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i, indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }
};
```

**Solution 2:**

```c++
// 使用 map，O(n) 两次O(n)级别的for循环
// Status: Accept
// Runtime: 20ms
// Memory: 10.5MB
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> indices(2);
        size_t n = nums.size();
        map<int, int> m;
        for (int i = 0; i < n; ++i) {
            m[nums[i]] = i;
        }
        
        for (int i = 0; i < n; ++i) {
            int tmp = target - nums[i];
            if (m.find(tmp) != m.end() && m[tmp] != i) {
                indices[0] = i;
                indices[1] = m[tmp];
                break;
            }
        }
        return indices;
    }
};
```

**Solution 3:**

```c++
// 使用 map，O(n) 只用一个for循环,map中记录的是target - nums[i]的索引
// Status: Accept
// Runtime: 8 ms
// Memory: 10.2 MB
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> indices(2);
        size_t n = nums.size();
        map<int, int> m;
        for (int i = 0; i < n; ++i) {
            if (m.find(nums[i]) != m.end()) {
                indices[0] = i;
                indices[1] = m[nums[i]];
                break;
            } else {
                m[target - nums[i]] = i;
            }
        }
            
        return indices;
    }
};
```

