package com.yore.medium;

/**
 * @author Yore
 * @date 2022/4/29 9:02
 * @description
 */
public class Number427 {
    int[][] grid;
    int[][] ops = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public Node construct(int[][] grid) {
        this.grid = grid;
        int len = grid.length;
        int val = isSame(0, 0, len);
        if (val != -1) {
            return new Node(val == 1, true);
        }
        return dfs(0, 0, len, null);
    }

    public Node dfs(int row, int col, int len, Node parent) {
        int mid = len / 2;
        Node[] nodes = new Node[4];
        int idx = 0;
        if (parent == null) {
            parent = new Node(true, false);
        }
        for (int[] op : ops) {
            int r = row + op[0] * mid;
            int c = col + op[1] * mid;
            int val = isSame(r, c, mid);
            if (val != -1) {
                parent.topLeft = new Node(true, false);
                nodes[idx] = new Node(val == 1, true);
            } else {
                nodes[idx] = new Node(true, false);
                dfs(r, c, mid, nodes[idx]);
            }
            idx++;
        }
        parent.topLeft = nodes[0];
        parent.topRight = nodes[1];
        parent.bottomLeft = nodes[2];
        parent.bottomRight = nodes[3];
        return parent;
    }

    public int isSame(int row, int col, int len) {
        int val = grid[row][col];
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (grid[i][j] != val) {
                    return -1;
                }
            }
        }
        return val;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};