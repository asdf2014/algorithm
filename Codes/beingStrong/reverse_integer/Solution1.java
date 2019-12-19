import java.util.*;
class Solution1 {

    public int reverse(int x) {
        //声明一个保存结果的res
        int res=0;

        while(x!=0){
            //如果res>Integer.MAX_VALUE/10或者res为Integer.MAX_VALUE/10但是p的值大于7,此时已经溢出，返回0
            if((res>Integer.MAX_VALUE/10)||(res==Integer.MAX_VALUE/10&&x%10>7)) return 0;
            //如果res<Integer.MIN_VALUE/10或者res为Integer.MIN_VALUE/10但是p的值小于-8,此时已经溢出，返回0
            if((res<Integer.MIN_VALUE/10)||(res==Integer.MIN_VALUE/10&&x%10<-8)) return 0;
            res=res*10+x%10;

            x/=10;

        }

        return res;
    }
}