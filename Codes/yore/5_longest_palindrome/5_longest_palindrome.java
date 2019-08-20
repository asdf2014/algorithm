/**
 * 实现思路：
 * <p>
 * 外层遍历一次字符串，对于每一个字符进行两次中心扩展比较
 * <p>
 * 时间复杂度为O(n^2)
 *
 * @param s 输入字符
 * @return 输出结果
 */
public static String longestPalindrome(String s) {
    String longestStr = "";
    String tempStr1 = "";
    String tempStr2 = "";
    for (int i = 0; i < s.length(); i++) {
        tempStr1 = palindrome(s, i, i);
        tempStr2 = palindrome(s, i, i + 1);
        if (tempStr1.length() >= tempStr2.length()) {
            longestStr = longestStr.length() >= tempStr1.length() ? longestStr : tempStr1;
        } else {
            longestStr = longestStr.length() >= tempStr2.length() ? longestStr : tempStr2;
        }
    }
    return longestStr;

}

/**
 * 采用中心扩展法查找当前索引位置的最长回文字符串
 * 回文字符串有两种形式：
 * 如果字符串是奇数，则中心位置为一个字符串
 * 如果字符串为偶数，则中心位置位相邻的两个字符串
 *
 * @param s       查找字符串
 * @param median1 中心位置1
 * @param median2 中心位置2
 * @return
 */
public static String palindrome(String s, int median1, int median2) {
    while (median1 >= 0 && median2 < s.length()) {
        if (s.charAt(median1) == s.charAt(median2)) {
            median1--;
            median2++;
        } else {
            break;
        }
    }
    return s.substring(++median1, median2);
}