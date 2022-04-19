package com.yore.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/2/19 17:26
 * @description
 */
public class Number969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[index]) {
                    index = j;
                }
            }
            if (index == i) {
                continue;
            }
            reverse(arr, index);
            reverse(arr, i);
            list.add(index + 1);
            list.add(i + 1);
        }
        return list;
    }

    public void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
