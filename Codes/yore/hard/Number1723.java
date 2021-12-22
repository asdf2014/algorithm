package com.yore.hard;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/5/8 8:00
 * @description
 */
public class Number1723 {
    int[] jobs;
    int n, k;
    int ans = 0x3f3f3f3f;
    public int minimumTimeRequired(int[] _jobs, int _k) {
        jobs = _jobs;
        n = jobs.length;
        k = _k;
        int[] sum = new int[k];
        dfs(0, 0, sum, 0);
        return ans;
    }
    /**
     * 【补充说明】不理解可以看看下面的「我猜你问」的 Q5 哦 ~
     *
     * u     : 当前处理到那个 job
     * used  : 当前分配给了多少个工人了
     * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
     * max   : 当前的「最大工作时间」
     */
    void dfs(int u, int used, int[] sum, int max) {
        if (max >= ans) {
            return;
        }
        if (u == n) {
            ans = max;
            return;
        }
        // 优先分配给「空闲工人」
        if (used < k) {
            sum[used] = jobs[u];
            dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[u];
            dfs(u + 1, used, sum, Math.max(sum[i], max));
            sum[i] -= jobs[u];
        }
    }

    /**
     * 贪心策略，针对特殊情况结果不正确，比如[4,4,4,5,5] k=2
     * @param jobs
     * @param k
     * @return
     */
    public int minimumTimeRequiredTest(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] result = new int[k];
        Arrays.fill(result, 0);
        int j = 0;
        for (int i = jobs.length - 1; i >= 0; i--) {
            if (j < k) {
                result[j++] = jobs[i];
            } else {
                Arrays.sort(result);
                result[0] += jobs[i];
            }
        }
        Arrays.sort(result);
        return result[k - 1];
    }


}
