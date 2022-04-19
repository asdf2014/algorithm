package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/2/22 15:43
 * @description
 */
public class Offer072 {
    public static void main(String[] args) {
        System.out.println(mySqrt(134134311));
    }
    public static int mySqrt(int x) {
        int left =1;
        int right = x/2;
        while(left<=right){
            int mid = left+(right-left)/2;
            long sqr = (long)mid * mid;
            if(sqr == x){
                return mid;
            }else if(sqr < x){
                left = mid+1;
            }else if (sqr > x){
                right = mid-1;
            }
        }
        return right;
    }
}
