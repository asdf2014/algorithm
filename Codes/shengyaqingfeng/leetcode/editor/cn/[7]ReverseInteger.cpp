// title : [7]ReverseInteger
// date : 2020-12-12 13:29:53
// author : creazyboyone
// note: WA了15次... run code 和 submit 环境不一样, 不得已在 submit 里面调试, 还要控制char数组最后一位设为\0
#include <iostream>
#include <cmath>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int reverse(int x) {
        bool flag = false;
        char p[32], q[32];
        sprintf(p, "%d", x);
        if (p[0] == '+' || p[0] == '-') {
            flag = true;
            q[0] = p[0];
        }
        int len = strlen(p);
        for (int i = flag ? 1 : 0; i < len; i++) {
            q[i] = p[len - i - (flag ? 0 : 1)];
        }
        char *qq = q;
        while (qq[0] == '0')
            qq++;
        q[len] = '\0';
        long long res = atoll(qq);
        cout << res << endl;
        return (res > 2147483647 || res < -2147483648) ? 0 : res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
