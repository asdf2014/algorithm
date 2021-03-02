import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:   Solution_77
 * Data:        2020/7/29
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_77 {
    public static void main(String[] args) {
        Arrays.asList(new Solution_77().combine(4,3)).forEach(r->{
            System.out.println(r.toString());
        });
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, 0, res, new ArrayList<>());
        return res;
    }

    public void helper(int n, int k, int index, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 剪枝 ① index + 1（不重复） ② 剩下的要够组合成k个数
        for (int i = index + 1; i <= n; i++) {
            // n - i + 1 --> 还剩这么多数   k - temp.size() --> 还需要这么多数
            if (n - i + 1 < k - temp.size())    // 供不应求
                break;
            temp.add(i);
            helper(n, k, i, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
