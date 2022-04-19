package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/17 9:02
 * @description
 */
public class Offer107 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        for (int[] a : res) {
            Arrays.fill(a, m * n);
        }
        Deque<Candidate> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    visit.add(i + "-" + j);
                    queue.add(new Candidate(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Candidate c = queue.poll();
            int x = c.x;
            int y = c.y;
            if (x > 0 && !visit.contains((x - 1) + "-" + y)) {
                res[x - 1][y] = Math.min(res[x - 1][y], res[x][y] + 1);
                visit.add((x - 1) + "-" + y);
                queue.add(new Candidate(x - 1, y));
            }
            if (x < m - 1 && !visit.contains((x + 1) + "-" + y)) {
                res[x + 1][y] = Math.min(res[x + 1][y], res[x][y] + 1);
                visit.add((x + 1) + "-" + y);
                queue.add(new Candidate(x + 1, y));
            }
            if (y > 0 && !visit.contains(x + "-" + (y - 1))) {
                res[x][y - 1] = Math.min(res[x][y - 1], res[x][y] + 1);
                visit.add(x + "-" + (y - 1));
                queue.add(new Candidate(x, y - 1));
            }
            if (y < n - 1 && !visit.contains(x + "-" + (y + 1))) {
                res[x][y + 1] = Math.min(res[x][y + 1], res[x][y] + 1);
                visit.add(x + "-" + (y + 1));
                queue.add(new Candidate(x, y + 1));
            }
        }
        return res;
    }

    class Candidate {
        int x;
        int y;

        public Candidate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
