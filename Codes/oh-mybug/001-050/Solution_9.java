/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_9
 * Data:        2020/7/12
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
9. 回文数
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution_9 {
    // 反转全部
    public static boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int temp = x;
        int res = 0, pop = 0;
        while (x != 0){
            pop = x%10;
            x /= 10;
            res = res*10 + pop;
        }
        if (res == temp) return true;
        return false;
    }

    // 反转一半
    public static boolean isPalindrome(int x){
        if (x < 0 || (x%10 == 0 && x != 0)) return false;
        int res = 0;
        while (x > res){
            res = res*10 + x/10;
            x /= 10;
        }
        return x == res || x == res/10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12121));
    }
}
