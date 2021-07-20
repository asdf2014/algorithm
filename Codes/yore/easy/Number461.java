package com.yore.easy;

/**
 * Created on 2019/1/25
 *
 * @author jiabingwen
 */

public class Number461 {
    public static void main(String[] args) {
        Number461 number461 = new Number461();
        long startTime = System.currentTimeMillis();
        System.out.println(number461.hammingDistance(1,4));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public int hammingDistance(int x, int y) {
        int count = 0;
        int result = x ^ y;
        String binaryStr = Integer.toBinaryString(result);
        for(int i=0;i<binaryStr.length();i++){
            if(binaryStr.charAt(i) =='1'){
                count++;
            }
        }
        return count;
    }
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
