package com.yore.hard;

import java.util.*;

/**
 * @author Yore
 * @date 2022/5/23 11:24
 * @description
 */
public class Number675 {
    int[][] dist = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int m = forest.size();
        int n = forest.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));
        int cx = 0;
        int cy = 0;
        int step = 0;
        for (int i = 0; i < trees.size(); i++) {
            int t = bfs(forest, cx, cy, trees.get(i)[0], trees.get(i)[1]);
            if (t == -1) {
                return -1;
            }
            step += t;
            cx = trees.get(i)[0];
            cy = trees.get(i)[1];
        }
        return step;
    }

    public int bfs(List<List<Integer>> forest, int cx, int cy, int tx, int ty) {
        if (cx == tx && cy == ty) {
            return 0;
        }
        int m = forest.size();
        int n = forest.get(0).size();
        int step = 0;
        Deque<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        queue.offerLast(new int[]{cx, cy});
        visited[cx][cy] = 1;
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] ord = queue.pollFirst();
                int x = ord[0];
                int y = ord[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dist[j][0];
                    int ny = y + dist[j][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (visited[nx][ny] != 1 && forest.get(nx).get(ny) > 0) {
                            if (nx == tx && ny == ty) {
                                return step;
                            }
                            queue.offerLast(new int[]{nx, ny});
                            visited[nx][ny] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
