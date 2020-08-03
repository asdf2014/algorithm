import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: Solution_849
 * Date:      2020/4/5 20:49
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
849. 到最近的人的最大距离
在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
至少有一个空座位，且至少有一人坐在座位上。
亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
返回他到离他最近的人的最大距离。

示例 1：
    输入：[1,0,0,0,1,0,1]
    输出：2
解释：
    如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
    如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
    因此，他到离他最近的人的最大距离是 2 。

示例 2：
    输入：[1,0,0,0]
    输出：3
解释：
    如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
    这是可能的最大距离，所以答案是 3 。
提示：
    1 <= seats.length <= 20000
    seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 */
public class Solution_849 {
    @Test
    public void test(){
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }
    /**
     * 实质是计算最大连续0的长度，头和尾特殊计算
     * currentEmptySeats作用：记录当前连续0的长度
     * maxDistance的作用：记录当前最大距离
     * temp的作用：用于遇到1准备比较当前距离和最大距离大小时，
     *            临时存储非头和尾时的最大距离（因为头和尾的
     *            最大距离直接就是currentEmptySeats）
     * head的作用：用于表示是否头为0
     * tail的作用：用于表示是否尾为0
     * 头和尾：maxDistance = currentEmptySeats
     * 非头和尾：maxDistance = currentEmptySeats%2 == 1 ? currentEmptySeats/2+1 : currentEmptySeats/2;
     * @Function maxDistToClosest
     * @author   Oh_MyBug
     * @Date     2020/4/5 21:51
     * @param
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int currentEmptySeats = 0;
        int maxDistance = 0;
        int temp;
        boolean head = false;
        boolean tail = false;
        if (seats[0] == 0) head = true;
        if (seats[seats.length-1] == 0) tail = true;
        for (int seat: seats){
            if (seat == 0){
                currentEmptySeats ++;
            }
            if (seat == 1){
                if (maxDistance != 0){
                    temp = currentEmptySeats%2 == 1 ? currentEmptySeats/2+1 : currentEmptySeats/2;
                    if (maxDistance < temp){
                        if (head){
                            head = false;
                        }
                        maxDistance = temp;
                    }
                }else{
                    if (!head) {
                        maxDistance = currentEmptySeats % 2 == 1 ? currentEmptySeats / 2 + 1 : currentEmptySeats / 2;
                    }else {
                        maxDistance = currentEmptySeats;
                    }
                }
                currentEmptySeats = 0;
            }
        }
        if (maxDistance < currentEmptySeats){
            maxDistance = currentEmptySeats;
        }else {
            tail = false;
        }
        return maxDistance;
    }
}
