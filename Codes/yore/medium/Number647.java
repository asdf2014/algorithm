package com.yore.medium;

/**
 * @author Yore
 * @date 2022/1/19 21:01
 * @description
 */
public class Number647 {
    public static void main(String[] args) {
        Number647 n = new Number647();
        System.out.println(n.countSubstrings("aaa"));
    }

    public int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count++;
            process(s, i - 1, i + 1);
            process(s, i, i + 1);
        }
        return count;
    }

    public void process(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left--) != s.charAt(right++)) {
                break;
            }
            count++;
        }
    }

    /**
     * 统计每个回文子串
     */
//    public int countSubstrings(String s) {
//        List<String> res = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            res.add(String.valueOf(s.charAt(i)));
//            res.addAll(process(s, i));
//        }
//        return res.size();
//    }
//
//
//    public List<String> process(String s, int index) {
//        List<String> list = new ArrayList<>();
//        int left = index - 1;
//        int right = index + 1;
//        while (left >= 0 && right < s.length()) {
//            if (s.charAt(left) != s.charAt(right)) {
//                break;
//            }
//            list.add(s.substring(left--, ++right));
//        }
//        left = index;
//        right = index + 1;
//        while (left >= 0 && right < s.length()) {
//            if (s.charAt(left) != s.charAt(right)) {
//                break;
//            }
//            list.add(s.substring(left--, ++right));
//        }
//        return list;
//    }
    public int countSubstrings2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += isPar(s, i, i);
            count += isPar(s, i, i + 1);
        }
        return count;
    }

    public int isPar(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l--) == s.charAt(r++)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
