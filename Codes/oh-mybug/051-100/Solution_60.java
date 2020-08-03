import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_60
 * Data:        2020/7/27
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
60. 第k个排列
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。
说明：
给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:
输入: n = 3, k = 3
输出: "213"
示例 2:
输入: n = 4, k = 9
输出: "2314"
 */
public class Solution_60 {
    /*public String getPermutation(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++)
            stringBuilder.append(i);
        char[] res = stringBuilder.toString().toCharArray();
        k--;
        for (int i = 0; i < k; i++)
            find_swap_sort(res, n);
        return String.valueOf(res);
    }

    public void find_swap_sort(char[] res, int n){
        int index = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (res[i] < res[i + 1]) {
                index = i;
                break;
            }
        }
        int aim = index + 1;
        char temp = res[index];
        for (int i = index + 2; i < n; i++)
            aim = (res[aim] > res[i] && (res[i] - temp) > 0) ? i : aim;
        res[index] = res[aim];
        res[aim] = temp;
        Arrays.sort(res, index + 1, n);
    }*/

    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        List<Integer> nums = new ArrayList() {{add(1);}};

        factorials[0] = 1;
        for(int i = 1; i < n; ++i) {
            // generate factorial system bases 0!, 1!, ..., (n - 1)!
            factorials[i] = factorials[i - 1] * i;
            // generate nums 1, 2, ..., n
            nums.add(i + 1);
        }

        // fit k in the interval 0 ... (n! - 1)
        --k;

        // compute factorial representation of k
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > -1; --i) {
            int idx = k / factorials[i];
            k -= idx * factorials[i];

            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution_60().getPermutation(3, 3));
    }
}
