// title : [10]RegularExpressionMatching
// date : 2020-12-14 20:13:37
// author : creazyboyone
// note : 从头到尾扫一遍，记录每个字符和前一个字符
// 遇到 . 匹配任意一个
// 遇到 * 匹配零个多个相同的
// 遇到 .* 匹配零个或多个任意字符，直到下一个字母相同(下n个好像也行) s: abbbaaaabbbbd p: a.*bd
// 好像行不通，没思路了 .* 好难确定是匹配哪一串，循环+回溯?
// .* 先匹配 a[]b... | a[b]b... | a[bb]b... | a[bbbaaaab]b | a[bbbaaaabb]b... | a[bbbaaaabbb]b...
// 额，貌似可以, 那 a.*b.*d | .*.*.* 呢? ... 多少个 .* 就循环+回溯一次, 直到遍历完成符合情况, 否则不匹配
// 好像可以, 不过咋回溯呢？
// 调了4个多小时，快好了，可能出现的情况有点多，疯狂递归，先睡觉
// -------
// update: 2021-12-22 21:27:37
// 不知不觉鸽了一年多，时隔1年多，该填坑了~~~
// 在递归前处理一下 case "a*a*a*a*a*a*a*a*a*a*c" ==> "a*c"
// 同理 ".*.*.*.*" ==> ".*"
// -------
// update: 2022-01-16 15:47:17
// 换了个电脑继续硬钢
// update: 2022-06-19 00:10:21
// 又换回来了，继续硬钢
// update: 2022-09-30 21:59:21
// 国庆节，没解决前决不看下一题（逻辑忘光了，靠注释回忆）
// fix case
// 想重新推翻重写，想到一个好思路：先解析p，然后分小节，一个小节有三种情况（a | a* | .* | .)
// 如：".*b.*c*.*.*.c*a*.c" ==> [.*|b|.*|c*|.*|.*|.|c*|a*|.|c]
// 先优化重复的小节，比如[...|.*|.*|...],[...|a*|a*|...]
// 然后同理匹配（好像也一样，还是得从头匹配，算了）
// 成功了，我是傻逼，以后谨慎做HARD级别的了，太费脑了


#include <iostream>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    bool firstSub = true;
public:
    bool isMatch(string s, string p) {
        // 避免多重递归，先处理多个*相连的情况: a*a*a*  b*b*b*
        // 寻找*，题目必不可能第一个就是*，不用担心从1开始
        // 截取只处理一次
        // 如果p不够长，不能到p[rpi + 2]，就不存在这个问题，直接跳过
        if (firstSub && p.size() > 3) {
            for (int rpi = 1; (rpi <= p.size() - 3); ++rpi) {
                // p不是最后，有*，开始检查*前后字符是不是相同
                if ((p[rpi] == '*') && (p[rpi + 2] == '*') && p[rpi - 1] == p[rpi + 1]) {
                    string pNew = p.substr(0, rpi - 1).append(p.substr(rpi + 1, p.size()));
                    cout << "子截取：p->" << p << " pnew->" << pNew << endl;
                    return isMatch(s, pNew);
                }
            }
            firstSub = false;
        }

        // 开始
        int si = 0;
        for (int pi = 0; pi < p.size(); ++pi, ++si) {
            if (p[pi] == '.') {
                if (pi < p.size() - 1 && p[pi + 1] == '*') {
                    // 如果 .* 是最后的可直接匹配所有
                    if (pi + 2 == p.size()) {
                        return true;
                    } else {
                        // 如果不是最后，依次匹配剩下的匹配，如果其中一个匹配上，那么整体就能匹配上
                        pi += 2;
                        // 如果是空值，直接跳过匹配
                        if (s == "" || si == s.size()) {
                            string subp = p.substr(pi, p.size() - pi);
                            cout << "子空值匹配：s->" << " p->" << subp << endl;
                            if (isMatch("", subp)) {
                                return true;
                            }
                            cout << "子空值子匹配：s->" << " p->" << subp << " => 匹配失败" << endl;
                            // s 是空值或者匹配完了，且剩下的q无法匹配，直接false
                            return false;
                        }
                        // 先找找有没有 .* 后面的字符
                        // 如果后面的字符是 .
                        if (p[pi] == '.') {
                            int pos = 0;
                            while (pos <= s.size() - 1) {
                                string subs = s.substr(pos, s.size() - pos);
                                string subp = p.substr(pi, p.size() - pi);
                                cout << "子匹配：s->" << subs << " p->" << subp << endl;
                                if (isMatch(subs, subp)) {
                                    return true;
                                }
                                cout << "子匹配：s->" << subs << " p->" << subp << " => 匹配失败" << endl;
                                pos++;
                            }
                            // 找不到，不能匹配
                            return false;
                        } else {
                            // 这里只可能是 .*aa.*ab 或者 .*a*b*..xax 不可能是 .** 或其他
                            // 这里不能直接无脑去找a 因为有可能是 a* 匹配 ""
                            // 没有好方法，只能循环子匹配，直到找出匹配的上的 .*
                            for (int i = 0; si + i < s.size() + 1; i++) {
                                string subs = s.substr(si + i, s.size() - si - i);
                                string subp = p.substr(pi, p.size() - pi);
                                cout << "循环子匹配：s->" << subs << " p->" << subp << " 【.*】 代表：【" << s.substr(si, i) << "】" << endl;
                                if (isMatch(subs, subp)) {
                                    return true;
                                }
                                // 此轮匹配失败，下一轮
                                cout << "循环子匹配：s->" << subs << " p->" << subp << " => 匹配失败，下一轮" << endl;
                            }
                            // 循环完了，还是匹配不上，直接失败
                            return false;
                        }
                    }
                } else if (si == s.size()) {
                    // s 匹配完了，p还没完
                    // 不能直接停止匹配，因为p后面有.*a*等也是可以匹配的
                    if (p[pi + 1] == '*') {
                        // .*和a*两种情况或者是组合
                        string pStr = p.substr(pi + 2, p.size() - pi);
                        cout << "s匹配完了，p还没完" << endl;
                        cout << "空值匹配：s-> " << " p->" << pStr << endl;
                        return isMatch("", pStr);
                    } else {
                        // .a或..无法匹配
                        return false;
                    }
                } else if (pi == p.size()) {
                    // p找完了，s还有东西
                    return false;
                } else {
                    cout << "匹配：. ==> " << s[si] << endl;
                    continue;
                }
            } else if (p[pi + 1] == '*') {
                // 如果 * 是最后的可判断后面的字母是否全是相同的
                // 这里有个坑 s: abbbbc  p: ab*bc
                if (pi + 2 == p.size()) {
                    while (si < s.size() && s[si] == p[pi]) {
                        si++;
                    }
                    if (si == s.size()) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    // 这里可能存在s匹配完了，p没完，和上面一样
                    // 不能直接停止匹配，因为p后面有.*a*等也是可以匹配的
                    if (s == "" || si == s.size()) {
                        // .*和a*两种情况或者是组合
                        string pStr = p.substr(pi + 2, p.size() - pi);
                        cout << "s匹配完了，p还有" << endl;
                        cout << "空值匹配：s-> " << " p->" << pStr << endl;
                        return isMatch("", pStr);
                    }
                    while (s[si] == p[pi]) {
                        string subs = s.substr(si, s.size() - si);
                        string subp = p.substr(pi + 2, p.size() - pi - 2);
                        cout << "子匹配：s->" << subs << " p->" << subp << endl;
                        if (isMatch(subs, subp)) {
                            cout << endl;
                            return true;
                        }
                        cout << "子匹配：s->" << subs << " p->" << subp << " => 匹配失败" << endl;
                        si++;
                    }
                    string subs = s.substr(si, s.size() - si);
                    string subp = p.substr(pi + 2, p.size() - pi - 2);
                    cout << "子匹配：s->" << subs << " p->" << subp << endl;
                    if (isMatch(subs, subp)) {
                        cout << endl;
                        return true;
                    }
                    cout << "子匹配：s->" << subs << " p->" << subp << " => 匹配失败" << endl;
                    // while 遍历完没有符合的
                    return false;
                }
            } else if (s[si] != p[pi]) {
                return false;
            } else {
                cout << "匹配：" << s[si] << endl;
            }
        }
        if (si < s.size()) {
            // p 匹配完了，s 还没完
            return false;
        }
        return true;
    }
};
//leetcode submit region end(Prohibit modification and deletion)