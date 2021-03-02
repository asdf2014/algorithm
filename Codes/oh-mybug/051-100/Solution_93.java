import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:   Solution_93
 * Data:        2020/8/1
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
示例:
输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution_93 {
    public static void main(String[] args) {
        Arrays.asList(new Solution_93().restoreIpAddresses("010010")).forEach(System.out::println);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, 0, res, new StringBuilder());
        return res;
    }

    public void helper(String s, int index, int count, List<String> res, StringBuilder stringBuilder) {
        if (index == s.length() && count == 4) {
            res.add(stringBuilder.toString());
            return;
        }
        if (index == s.length() || count == 4)
            return;

        if (count != 0)
            stringBuilder.append(".");

        stringBuilder.append(s.charAt(index));
        helper(s, index + 1, count + 1, res, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        if (s.charAt(index) != '0') {
            if (index + 1 < s.length()) {
                stringBuilder.append(s, index, index + 2);
                helper(s, index + 2, count + 1, res, stringBuilder);
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            }

            if (index + 2 < s.length()) {
                // (s.charAt(index) - '0') * 100 + (s.charAt(index + 1) - '0') * 10 + (s.charAt(index + 2) - '0') <= 255
                if (Integer.parseInt(s.substring(index, index + 3)) <= 255) {
                    stringBuilder.append(s, index, index + 3);
                    helper(s, index + 3, count + 1, res, stringBuilder);
                    stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
                }
            }
        }

        if (count != 0)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
