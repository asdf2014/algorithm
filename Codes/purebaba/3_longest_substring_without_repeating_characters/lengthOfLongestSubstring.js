// 个人原始思路
// 先找到所有字符串中的单字符元素
// 循环截取原始字符串，并判断截取结果是否存在重复字符，若不重复则该字符串就是当前字符串中最无重复字符的最长子串
// 性能太差，需要优化
let lengthOfLongestSubstring = function (s) {
    let all = s.split('');
    let elements = new Set(all);
    for (let i = elements.size; i > 0; i--) {
        for (let c = 0; c <= s.length - i; c++) {
            let ts = s.substr(c, s.length);
            while (ts.length >= i) {
                let t = ts.substr(0, i);
                if (!isRepeat(t)) return t.length;
                ts = ts.substr(i, ts.length);
            }
        }
    }
    return 0;
};

//和1一样，都是暴利搜索，性能较差
let lengthOfLongestSubstring_1 = function (s) {
    let all = s.split('');
    let elements = new Set(all);
    let max_len = 0;
    for (let j = 0; j < s.length; j++) {
        let map = {};
        let len = 0;
        for (let i = j; i < s.length; i++) {
            let e = s[i];
            if (!map[e]) {
                map[e] = 1;
                len++;
            } else {
                map[e] += 1;
            }
            if (map[e] > 1) {
                map[e] = 1;
                len = 1;
                continue;
            }
            if (max_len < len) {
                max_len = len;
            }
        }
        if (max_len === elements.size) {
            return max_len;
        }
    }
    return max_len;
};

let isRepeat = function isRepeat(s) {
    let l = s.split('');
    let b = {};
    for (let e in l) {
        if (!b[l[e]]) {
            b[l[e]] = 1;
        } else {
            b[l[e]] += 1;
        }
        if (b[l[e]] > 1) {
            return true;
        }
    }
    return false;
};


//滑动窗口
let lengthOfLongestSubstring_3 = function (s) {
    let l = s.length;
    let max_len = 0;
    let i = 0, j = 0;
    let set = new Set();
    while (i < l && j < l) {
        if (!set.has(s[j])) {
            set.add(s[j]);
            j++;
            max_len = Math.max(max_len, j - i);
        } else {
            set.delete(s[i]);
            i++;
        }

    }
    return max_len;
};


console.log(lengthOfLongestSubstring_3("asjrgapa"));

