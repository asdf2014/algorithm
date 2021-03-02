/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_6
 * Data:        2020/7/12
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
6. Z 字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);

示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"

示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G

 */
public class Solution_6 {
    public static void main(String[] args) {
        System.out.println(convert("L", 2));
    }
    public static String convert(String s, int numRows){
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    public static String convert2(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length();   // len = 16
        if (len == 0) return "";
        char[] chars = s.toCharArray();
        String str = new String();
        int num = (2*(numRows-1)), group = (int) Math.ceil(len/(double)num);    // num = 6 group = 3
        for (int j = 0; j < num - numRows + 2; j++) {
            for (int i = 0; i < group; i++) {
                if (j == 0 || j == num - numRows + 1) {
                    if (i * num + j < len)
                        str += chars[i * num + j];
                }else{
                    if (i*num + j < len)
                        str += chars[i*num + j];
                    if (i*num + num-j < len)
                        str += chars[i*num + num-j];
                }
            }
        }
        return str;
    }
    public static String convert1(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length();
        if (len == 0) return "";
        char[] chars = s.toCharArray();
        int[] rows = new int[len], cols = new int[len];
        boolean down = true;
        rows[0] = 0;
        cols[0] = 0;
        for (int i = 1; i < len; i++) {
            if (down){
                rows[i] = rows[i - 1] + 1;
                cols[i] = cols[i-1];
                if (rows[i] == numRows - 1)
                    down = false;
            }else if (!down){
                rows[i] = rows[i - 1] - 1;
                cols[i] = cols[i-1] + 1;
                if (rows[i] == 0)
                    down = true;
            }
        }
        String str = new String();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                if (rows[j] == i)
                    str += chars[j];
            }
        }
        return str;
    }
}
