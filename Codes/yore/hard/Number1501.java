package com.yore.hard;

/**
 * @author Yore
 * @date 2022/3/24 10:03
 * @description
 */
public class Number1501 {

    public boolean winnerSquareGame(int n) {
        return Math.sqrt(n) == Math.floor(Math.sqrt(n));
    }
}
