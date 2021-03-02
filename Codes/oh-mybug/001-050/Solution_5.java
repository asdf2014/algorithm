/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_5
 * Data:        2020/7/11
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */
public class Solution_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    // 动态规划
    // 状态转移方程P(i,j) = P(i+1,j−1) ∧ ( S(i) == S(j) )
    // 只有 s[i+1:j-1]s[i+1:j−1] 是回文串，并且 ss 的第 ii 和 jj 个字母相同时，s[i:j]s[i:j] 才会是回文串。
    public static String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        char[] chars = s.toCharArray(), longest;
        int len = chars.length, min = 0, max = 0;
        boolean[][] dp = new boolean[len][len];
        // 枚举子串的长度 l+1
        for (int l = 0; l < len; l++) {
            // 枚举子串的起始位置 i，这样可以通过 j=i+l 得到子串的结束位置
            for (int i = 0; i < len - 1; i++) {
                int j = i + l;
                if (j >= len) break;
                if (l == 0)
                    dp[i][j] = true;
                else if (l == 1 )
                    dp[i][j] = (chars[i] == chars[j]);
                else
                    dp[i][j] = dp[i+1][j-1] && chars[i] == chars[j];
                if (dp[i][j] && l+1 > max-min+1){
                    min = i;
                    max = j;
                }
            }
        }
        longest = new char[max-min+1];
        for (int i = 0; i <= max-min; i++) {
            longest[i] = chars[min + i];
        }
        return String.valueOf(longest);
    }

    public char[] reverseString(char[] c){
        int len = c.length;
        char[] new_c = new char[len];
        for (int i = 0; i < len; i++)
            new_c[i] = c[len-i-1];
        return new_c;
    }

    public static ListNode<Character> generateLinkedList(String s){
        Character[] characters = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        ListNode<Character> root = new ListNode<>('0');
        root.add(characters);
        return root;
    }

    public static ListNode<Character> reverseLinkedList(ListNode<Character> root){
        ListNode<Character> newRoot = copyLinkedList(root);
        ListNode<Character> cur = newRoot.next, p = null;
        if (cur == null) return newRoot;
        while (cur.next != null){
            p = cur.next;
            cur.next = p.next;
            p.next = newRoot.next;
            newRoot.next = p;
        }
        return newRoot;
    }

    public static ListNode<Character> copyLinkedList(ListNode<Character> root){
        ListNode<Character> cur = root.next,
                newRoot = new ListNode<>('0'),
                newCur = newRoot;
        while (cur != null) {
            newCur.next = new ListNode(cur.val);
            cur = cur.next;
            newCur = newCur.next;
        }
        return newRoot;
    }

    public static boolean isEqual(ListNode<Character> l1, ListNode<Character> l2){
        while (l1 != null){
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
