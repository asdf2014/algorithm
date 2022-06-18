package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/19 15:32
 * @description
 */
public class Offer086 {
    public static void main(String[] args) {
        Offer086 o = new Offer086();
        String[][] result = o.partition("abbab");
        for (String[] r : result) {
            System.out.print("[");
            for (String s : r) {
                System.out.print(s + ",");
            }
            System.out.print("]");
        }
    }

    public List<List<String>> res = new ArrayList<>();

    public String[][] partition(String s) {
        helper(s, 0, new ArrayList<>());
        String[][] result = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = new String[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                result[i][j] = res.get(i).get(j);
            }
        }
        return result;
    }

    public boolean isPalindrom(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public void helper(String s, int index, List<String> list) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrom(s, index, i)) {
                String cur = s.substring(index, i + 1);
                list.add(cur);
                helper(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 一个字符串的所有回文子串
     *
     * @param s
     * @return
     */
    public List<String> palindrome(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            res.add(String.valueOf(s.charAt(i)));
            res.addAll(process(s, i));
        }
        return res;
    }

    public List<String> process(String s, int index) {
        List<String> list = new ArrayList<>();
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            list.add(s.substring(left--, ++right));
        }
        left = index;
        right = index + 1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            list.add(s.substring(left--, ++right));
        }
        return list;
    }
}
