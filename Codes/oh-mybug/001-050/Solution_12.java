/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_12
 * Data:        2020/7/13
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
示例 1:
输入: 3
输出: "III"
示例 2:
输入: 4
输出: "IV"
示例 3:
输入: 9
输出: "IX"
示例 4:
输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
示例 5:
输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Solution_12 {
    // 逐一判断
    public static String intToRoman1(int num) {
        String roman = "";
        String[] specific_4 = new String[]{"IV", "XL", "CD"};
        String[] specific_9 = new String[]{"IX", "XC", "CM"};
        String[] symbol1 = new String[]{"I", "X", "C", "M"};
        String[] symbol2 = new String[]{"V", "L", "D"};
        String temp = "";
        int pop = 0;
        for (int i = 0; i < 4; i++) {
            pop = num%10;
            num /= 10;
            if (pop < 5){
                if (pop == 4) roman = specific_4[i] + roman;
                else {
                    temp = "";
                    while ((pop--) != 0)
                        temp = symbol1[i] + temp;
                    roman = temp + roman;
                }
            }else {
                if (pop == 9) roman = specific_9[i] + roman;
                else {
                    temp = "";
                    temp = symbol2[i] + temp;
                    for (int j = 0; j < pop - 5; j++)
                        temp = temp + symbol1[i];
                    roman = temp + roman;
                }
            }
        }
        return roman;
    }

    // 贪心
    public static String intToRoman(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer roman = new StringBuffer();
        int len = values.length;
        for (int i = 0; i < len; i++) {
            while (num >= values[i]){
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
