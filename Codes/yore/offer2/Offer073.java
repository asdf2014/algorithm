package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/11 8:56
 * @description
 */
public class Offer073 {
    public static void main(String[] args) {
        Offer073 o = new Offer073();
        System.out.println(o.minEatingSpeed(new int[]{3,6,7,11},8));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        for(int pile : piles){
            max = Math.max(max,pile);
        }
        int n = piles.length;
        // 以max的速度 需要n小时吃完
        int l=1;
        int r = max+1;
        while(l<r){
            int mid = l + (r - l) / 2;
            if(isDone(piles,h,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r;
    }

    public boolean isDone(int[] piles,int h,int speed){
        int res = 0;
        for(int pile : piles){
            res += Math.ceil(pile / (double)speed);
        }
        return res<=h;
    }
}
