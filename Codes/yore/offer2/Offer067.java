package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/9 10:13
 * @description
 */
public class Offer067 {
    class TrieNode {
        private TrieNode[] trieNode;

        public TrieNode() {
            this.trieNode = new TrieNode[2];
        }
    }

    private TrieNode trieNode;
    private int BIT = 30;

    public int findMaximumXOR(int[] nums) {
        buildTrie(nums);
        int maxXOR = Integer.MIN_VALUE;
        for (int num : nums) {
            maxXOR = Math.max(maxXOR, searchMaxXOR(num));
        }
        return maxXOR;
    }

    public void buildTrie(int[] nums) {
        this.trieNode = new TrieNode();
        for (int num : nums) {
            TrieNode node = this.trieNode;
            for (int d = BIT; d >= 0; d--) {
                int b = num >> d & 1;
                if (node.trieNode[b] == null) {
                    node.trieNode[b] = new TrieNode();
                }
                node = node.trieNode[b];
            }
        }
    }

    public int searchMaxXOR(int num) {
        TrieNode cur = this.trieNode;
        int xorNum = 0;
        for (int i = 30; i >= 0; i--) {
            int d = num >> i & 1;
            int other = (d - 1) * -1;
            if (cur.trieNode[other] != null) {
                xorNum = xorNum * 2 + other;
                cur = cur.trieNode[other];
            } else {
                xorNum = xorNum * 2 + d;
                cur = cur.trieNode[d];
            }
        }
        return num ^ xorNum;
    }
}
