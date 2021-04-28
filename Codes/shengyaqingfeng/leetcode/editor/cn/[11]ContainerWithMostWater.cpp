// title : [11]ContainerWithMostWater
// date : 2021-02-11 20:37:43
// author : creazyboyone
// note : 传统艺能，新年刷几道压压身。寓意开发者不能忘本。技术改变未来，朝着梦想前进！！！
// 思路 ： 暴搜，遍历所有长方形，然后计算面积，返回最大的
// 额，居然超时了，从中间试起？从外围试起？好像也不行，好像可以从最高的柱子开始
// 先依次找最高的记录下来，然后新找的较低和记录高的依次计算....好像也不行，还是要遍历一遍
// 看看能不能省下一部分计算，瞄了一眼题解，看到了双指针 emm......
// 意思是左右一个指针咯，往中间移动，那不还是暴搜吗，贪心？万一存在内部的局部最优解呢？
// 重点是结束条件是什么？？？不然还是全部遍历
// 时隔N年，终于回来了~~~所以双指针是怎么实现的？
// 实际上，是求最大矩形面积！尽量拉长和拉高，涉及到在无规则图形中，如何放下最大矩形，也不是
// 不行，算了看题解，玛德动规, 还有另外一个貌似不可行的方法：
// 我们选择指针所指的高较小的那个指针进行移动，这样我们就保留了容器较高的那条边，放弃了较小的那条边，以获得有更高的边的机会。
// 好像想错了，指针每缩小一次，就判断缩小左边还是缩小右边使得面积最大，这个没问题。
// 疑虑的是，上面提到的万一存在内部部的局部最优解, 循环算到外面发现，指针再缩小(无论左右)后, 面积无法加大
// 就像下面这样，于是循环就停止了
// [3, 5, 30, 3, 44, 2, 5] => 3 * 6 => 5 * 5 => 25 < 30 * 2
// 如果不停止会怎样？不停止就会覆盖所有可能的最优解，nice，直到来个指针差1或者碰到一起

#include <iostream>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int maxArea(vector<int> &height) {
        int total = 0;
        int left = 0, right = height.size() - 1;
        while (left < right) {
            total = max(total, (right - left) * min(height[left], height[right]));
            if (height[left] > height[right]) {
                --right;
            } else {
                ++left;
            }
        }
        return total;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
