/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_14
 * Data:        2020/7/13
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
 */
public class Solution_14 {
    // 纵向扫描
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        char ch;
        while (true){
            if (strs[0].length() == index)
                return stringBuilder.toString();
            ch = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++)
                if (strs[i].length() == index || ch != strs[i].charAt(index))
                    return stringBuilder.toString();
            stringBuilder.append(ch);
            index ++;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{""}));
    }
}
