package com.yore.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yore
 * @date 2022/2/21 9:12
 * @description
 */
public class Number838 {
    public static void main(String[] args) {
        System.out.println(pushDominoes(".L.R...LR..L.."));
    }

    public static String pushDominoes(String dominoes) {
        int len = dominoes.length();
        char[] arr = new char[len];
        char[] pre = new char[len];
        Set<Integer> indexSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            arr[i] = dominoes.charAt(i);
            if (arr[i] == '.') {
                indexSet.add(i);
            }
        }
        boolean change = true;
        while (change) {
            List<Integer> modifyList = new ArrayList<>();
            System.arraycopy(arr, 0, pre, 0, len);
            change = false;
            for (int i : indexSet) {
                if (i == 0) {
                    if (i + 1 < len) {
                        if (arr[i] == '.' && pre[i + 1] == 'L') {
                            arr[i] = 'L';
                            change = true;
                            modifyList.add(i);
                        }
                    }
                } else if (i == len - 1) {
                    if (i - 1 >= 0) {
                        if (arr[i] == '.' && pre[i - 1] == 'R') {
                            arr[i] = 'R';
                            change = true;
                            modifyList.add(i);
                        }
                    }
                } else {
                    if (arr[i] == '.') {
                        if (pre[i + 1] == 'L' && pre[i - 1] != 'R') {
                            arr[i] = 'L';
                            modifyList.add(i);
                            change = true;
                        } else if (pre[i + 1] == 'R' && pre[i - 1] == 'R') {
                            arr[i] = 'R';
                            modifyList.add(i);
                            change = true;
                        } else if (pre[i - 1] == 'R' && pre[i + 1] == '.') {
                            arr[i] = 'R';
                            modifyList.add(i);
                            change = true;
                        }
                    }
                }
            }
            for (int idx : modifyList) {
                indexSet.remove(idx);
            }
        }
        return new String(arr);
    }
}
