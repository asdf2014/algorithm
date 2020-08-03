/**
 * ClassName: com.ohmybug.Solution_96
 * Date:      2020/4/17 16:25
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
示例:
    输入: 3
    输出: 5
解释:
    给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
 */
public class Solution_96 {
    public static void main(String[] args) {
        System.out.println(Solution_96.numTrees(3));
    }
    public static int numTrees(int n) {
       int[] G = new int[n+1];
       G[0] = 1;
       G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                G[i] += G[j] * G[i-j-1];
            }
        }
//       G[2] = G[0] * G[1] + G[1] * G[0];
//       G[3] = G[0] * G[2] + G[1] * G[1] + G[2] * G[0];
       return G[n];
    }
}
