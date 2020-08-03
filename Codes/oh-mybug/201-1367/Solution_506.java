import org.junit.Test;

/**
 * ClassName: Solution_506
 * Date:      2020/4/4 18:28
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
506. 相对名次
给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”
（"Gold Medal", "Silver Medal", "Bronze Medal"）。
(注：分数越高的选手，排名越靠前。)

示例 1:
    输入: [5, 4, 3, 2, 1]
    输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
    解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，
    “银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
    余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。

提示:
    N 是一个正整数并且不会超过 10000。
    所有运动员的成绩都不相同。
 */
public class Solution_506 {
    @Test
    public void test(){
        int[] nums = new int []{4,5,3,2,1,6};
        String[] ranks = findRelativeRanks(nums);
        for (String rank: ranks)
            System.out.println(rank);
    }
    /**
     * 核心函数，使用归并排序，返回排序后nums和对应的原位置索引index，
     * 通过索引index确定未排序前nums的相对排名
     * @Function findRelativeRanks
     * @author   Oh_MyBug
     * @Date     2020/4/4 22:11
     * @param
     * @return
     */
    public static String[] findRelativeRanks(int[] nums) {
        int[] index = new int[nums.length];
        String[] ranks = new String[nums.length];
        sort(nums, index);
        for (int i = 0; i < nums.length; i ++){
            ranks[index[i]] = Integer.toString(i);
            if (i == 0)
                ranks[index[i]] = "Gold Medal";
            if (i == 1)
                ranks[index[i]] = "Silver Medal";
            if (i == 2)
                ranks[index[i]] = "Bronze Medal";
        }
        return ranks;
    }
    /**
     * 归并排序
     * @Function sort
     * @author   Oh_MyBug
     * @Date     2020/4/4 22:10
     * @param
     * @return
     */
    private static void sort(int []nums, int[] index) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp1 = new int[nums.length];
        int[] temp2 = new int[nums.length];
        for (int i = 0; i < nums.length; i ++){
            index[i] = i;
        }
        sort(nums, index, 0, nums.length - 1, temp1, temp2);
    }
    private static void sort(int[] nums, int[] index, int left, int right, int[] temp1, int[] temp2){
        if (left < right){
            sort(nums, index, left, (left + right)/2, temp1, temp2);
            sort(nums, index, (left + right)/2 + 1, right , temp1, temp2);
            merge(nums, index, left, (left + right)/2, right, temp1, temp2);
        }
    }
    private static void merge(int []nums, int[] index, int left, int mid, int right, int[] temp1, int[] temp2){
        int i = left;
        int j = mid + 1;
        int t = 0 ;
        while (i <= mid && j <= right){
            if (nums[i] > nums[j]){
                temp1[t] = nums[i];
                temp2[t++] = index[i++];
            }else {
                temp1[t] = nums[j];
                temp2[t++] = index[j++];
            }
        }
        while (i <= mid){
            temp1[t] = nums[i];
            temp2[t++] = index[i++];
        }
        while (j <= right){
            temp1[t] = nums[j];
            temp2[t++] = index[j++];
        }
        t = 0;
        while (left <= right){
            nums[left] = temp1[t];
            index[left++] = temp2[t++];
        }
    }
}
