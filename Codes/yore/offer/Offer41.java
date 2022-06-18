package com.yore.offer;

import java.util.*;

/**
 * @author jia bing wen
 * @date 2021/7/13 7:53
 * @description
 */
public class Offer41 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {
        private List<Integer> list;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            this.list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            int len = list.size();
            boolean odd = len % 2 == 0;
            int index = odd ? len / 2 - 1 : len / 2;
            Collections.sort(list);
            return odd ? (list.get(index) + list.get(index + 1)) / 2.0 : list.get(index);
        }
    }


    class MedianFinder1 {
        Queue<Integer> A, B;
        public MedianFinder1() {
            A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
        }
        public void addNum(int num) {
            if(A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }
        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }

}
