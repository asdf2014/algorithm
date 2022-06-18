package com.yore.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author jia bing wen
 * @date 2021/7/9 8:56
 * @description
 */
public class Offer12 {
    private String word;
    private int row;
    private int col;
    private int[][] route;
    private boolean result;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.row = board.length;
        this.col = board[0].length;
        this.route = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        this.result = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                backtrace(board, i, j, 0, new LinkedList<>());
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }


    public void backtrace(char[][] board, int i, int j, int index, LinkedList<String> track) {
        if (index == word.length()) {
            result = true;
            return;
        }
        if (i >= row || i < 0 || j >= col || j < 0 || result) {
            return;
        }
        if (board[i][j] == word.charAt(index)) {
            index++;
            for (int k = 0; k < 4; k++) {
                if (track.contains(i + "_" + j)) {
                    continue;
                }
                track.add(i + "_" + j);
                backtrace(board, i + route[k][0], j + route[k][1], index, track);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Offer12 o = new Offer12();
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'A'}};
        System.out.println(o.exist(board, "A"));
    }
}
