/**
 * 解题思路： 总结规律
 * 0              10              20
 * 1           9  11           19
 * 2        8     12        18
 * 3     7        13     17
 * 4  6           14  16
 * 5              15
 * 行数=6， m=n-1=5
 * <p>
 * 第0行数据取值：   从0开始 每次间隔2*5取值    直到结束
 * 第1行数据取值：   从1开始 第一次间隔2*4取值  第二次间隔2*1取值  循环如此直到结束
 * 第2行数据取值：   从2开始 第一次间隔2*3取值  第二次间隔2*2取值  循环如此直到结束
 * .
 * .
 * 第n-1行数据取值： 从n-1开始 第一次间隔2*(m-i)取值  第二次间隔2*(n-1)取值  循环如此直到结束
 * 第n行数据取值：   从n开始 每次间隔2*m取值    直到结束
 *
 * @param s
 * @param numRows
 * @return
 */
public static String convert(String s, int numRows) {
    if (s.length() <= 1 || numRows == 1) {
        return s;
    }
    int m = numRows - 1;
    StringBuilder sb = new StringBuilder(s.length());
    for (int i = 0; i < numRows; i++) {
        int j = i;
        if (j < s.length()) {
            sb.append(s.charAt(j));
            while (j < s.length()) {
                if (i == 0 || i == numRows - 1) {
                    j += 2 * m;
                    if (j < s.length()) {
                        sb.append(s.charAt(j));
                    } else {
                        break;
                    }
                } else {
                    j += 2 * (m - i);
                    if (j < s.length()) {
                        sb.append(s.charAt(j));
                    } else {
                        break;
                    }
                    j += 2 * i;
                    if (j < s.length()) {
                        sb.append(s.charAt(j));
                    } else {
                        break;
                    }
                }
            }
        }
    }
    return sb.toString();
}