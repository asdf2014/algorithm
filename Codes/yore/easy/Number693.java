package com.yore.easy;

/**
 * @author Yore
 * @date 2022/3/28 8:13
 * @description
 */
public class Number693 {
    public static void main(String[] args) {


    }

    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for(int i=1;i<bits.length();i++){
            if(bits.charAt(i) == bits.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}
