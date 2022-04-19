package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/18 15:44
 * @description
 */
public class Offer085 {
    public List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        process(n, 0, "", 0);
        return res;
    }

    public void process(int n, int done, String path, int left) {
        if (left > n || done > n) {
            return;
        }
        if (left == n && done == n) {
            res.add(path);
            return;
        }
        int len = path.length();
        if (len == 0) {
            path += "(";
            process(n, done, path, left + 1);
            return;
        } else if (path.charAt(len - 1) == '(' || left > done) {
            path += ")";
            process(n, done + 1, path, left);
            path = path.substring(0, len);
        }
        path += "(";
        process(n, done, path, left + 1);
    }


    public void process2(int n, int done, String path, int left) {
        if (left > n || done > n) {
            return;
        }
        if (left == n && done == n) {
            res.add(path);
            return;
        }
        int len = path.length();
        if (path.charAt(len - 1) == '(' || left > done) {
            path += ")";
            process(n, done + 1, path, left);
            path = path.substring(0, len);
        }
        path += "(";
        process(n, done, path, left + 1);
    }
}
