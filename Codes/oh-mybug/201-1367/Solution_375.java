import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: Solution_375
 * Date:      2020/4/6 17:31
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
375. 猜数字大小 II

我们正在玩一个猜数游戏，游戏规则如下：
我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。
直到你猜到我选的数字，你才算赢得了这个游戏。

示例:
    n = 10, 我选择了8.

    第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
    第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
    第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。

    游戏结束。8 就是我选的数字。

    你最终要支付 5 + 7 + 9 = 21 块钱。
给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。
 */
public class Solution_375 {
    @Test
    public void test(){
        System.out.println(getMoneyAmount(6));
    }
    public int getMoneyAmount(int n) {
        List money = new ArrayList();
        for (int i = 1; i <= n; i ++){
            money.add(getMoney(1, n, i, 0));
        }
        return (int) Collections.max(money);
    }
    public int getMoney(int start, int end, int x, int money){
        int mid = (start + end)%2 == 0 ? (start + end)/2 : (start + end)/2 + 1;
        if (mid == x){
            return money;
        }
        if (mid < x) {
            return getMoney(mid+1, end, x, money + mid);
        }else{
            return getMoney(start, mid-1, x, money + mid);
        }
    }
}
