package com.yore.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yore
 * @date 2022/7/3 9:39
 * @description
 */
public class Number556 {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(21));
    }

    public static int nextGreaterElement(int n) {
        List<Integer> bitList = new ArrayList<>();
        int r = n;
        while (r != 0) {
            bitList.add(r % 10);
            r /= 10;
        }
        int size = bitList.size() - 1;
        int i = 1;
        while (i <= size && bitList.get(i) >= bitList.get(i - 1)) {
            i++;
        }
        if (i > size) {
            return -1;
        }
        for(int j=0;j<i;j++){
            if(bitList.get(j) > bitList.get(i)){
                int tmp = bitList.get(i);
                bitList.set(i, bitList.get(j));
                bitList.set(j, tmp);
                break;
            }
        }
        int[] last = new int[i];
        for (int j = 0; j < i; j++) {
            last[j] = bitList.get(j);
        }
        Arrays.sort(last);
        long x = 0;
        for (int idx = size; idx >= 0; idx--) {
            if (idx < i) {
                break;
            }
            x *= 10;
            x += bitList.get(idx);
        }
        for (int j = 0; j < i; j++) {
            x *= 10;
            x += last[j];
        }
        if (x > Integer.MAX_VALUE || x <= n) {
            return -1;
        }
        return (int) x;
    }
}
