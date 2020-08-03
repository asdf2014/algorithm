/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_29
 * Data:        2020/7/17
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
29. 两数相除
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例 1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

示例 2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2
 */
public class Solution_29 {
    public static int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) return 2147483647;
        // 都改为负号是因为int 的范围是[2^32, 2^32-1]，如果a是-2^32，转为正数时将会溢出
        int neg_dividend = dividend < 0 ? dividend : (-1)*dividend;
        int neg_divisor = divisor < 0 ? divisor : (-1)*divisor;
        if (neg_dividend > neg_divisor || neg_divisor == 0) return 0;
        int res = div(neg_dividend, neg_divisor);
        return ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) ? res : (-1)*res;
    }

    public static int div(int neg_dividend, int neg_divisor){
        if (neg_dividend > neg_divisor) return 0;
        int count = 1, temp = neg_divisor;
        // 需要判断接下来是否会溢出
        while ((temp << 1) >= neg_dividend && Integer.MIN_VALUE - temp < temp){
            count = count << 1; // 翻倍 *2
            temp = temp << 1;   // 翻倍 *2
        }
        return count + div(neg_dividend - temp, neg_divisor);
    }

    public static void main(String[] args) {
        System.out.println(divide(-10, -2));
    }
}
