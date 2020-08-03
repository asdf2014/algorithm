import java.util.ArrayList;

/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_20
 * Data:        2020/7/15
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
输入: "()"
输出: true
示例 2:
输入: "()[]{}"
输出: true
示例 3:
输入: "(]"
输出: false
示例 4:
输入: "([)]"
输出: false
示例 5:
输入: "{[]}"
输出: true

 */
public class Solution_20 {
    // 使用引用类型
    public static boolean isValid1(String s) {
        ArrayList<Character> list = new ArrayList<>();
        char[] right = new char[]{')',']','}'};
        char[] left = new char[]{'(','[','{'};
        int len = s.length();
        int symbol_len = right.length;
        for (int i = 0; i < len; i++) {
            list.add(s.charAt(i));
            for (int j = 0; j < symbol_len; j++) {
                if (list.get(list.size() - 1) == right[j]) {
                    if (list.size() == 1 || list.get(list.size() - 2) != left[j])
                        return false;
                    else {
                        list.remove(list.size() - 1);
                        list.remove(list.size() - 1);
                        break;
                    }
                }
            }
        }
        return list.size() == 0;
    }

    // 使用原始类型
    public static boolean isValid(String s) {
        char[] right = new char[]{')',']','}'};
        char[] left = new char[]{'(','[','{'};
        int len = s.length();
        char[] chars = new char[len];
        int chars_size = 0;
        for (int i = 0; i < len; i++) {
            chars[chars_size] = s.charAt(i);
            chars_size ++;
            for (int j = 0; j < left.length; j++) {
                if (right[j] == s.charAt(i)){
                    if (chars_size == 1 || chars[chars_size - 2] != left[j])
                        return false;
                    else
                        chars_size -= 2;
                }
            }
        }
        return chars_size == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
}
