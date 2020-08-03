/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_7
 * Data:        2020/7/12
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321

 示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution_7 {
    public static void main(String[] args) {
        System.out.println(reverse(-1534236469));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    // 基于64位环境
    public static int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            // 溢出检测
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            System.out.println(x % 10);
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

    public static int reverse1(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int len = chars.length, start = x > 0 ? 0 : 1, num = 0;
        String reverse_str = x > 0 ? new String() : new String("-");
        for (int i = len - 1; i >= start; i--) {
            reverse_str += chars[i];
        }
        try {
            num = Integer.valueOf(reverse_str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            return num;
        }
    }
}
