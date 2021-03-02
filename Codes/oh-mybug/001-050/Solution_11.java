/**
 * ClassName:   com.ohmybug.firstTofifty.Solution_11
 * Data:        2020/7/12
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
 */
public class Solution_11 {
    // 暴力破解
    public static int maxArea1(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                max = Math.max(Math.min(height[i],height[j])*(j-i), max);
            }
        }
        return max;
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int head = 0, tail = len-1;
        int max = 0;
        while (head < tail){
            max = Math.max(Math.min(height[head],height[tail])*(tail-head), max);
            if (height[head] > height[tail])
                tail --;
            else head ++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
