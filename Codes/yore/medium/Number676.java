package com.yore.medium;

/**
 * @author Yore
 * @date 2022/7/11 9:17
 * @description
 */
public class Number676 {

}

class MagicDictionary {
    public Node root;

    public MagicDictionary() {
        this.root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new Node();
                }
                node = node.next[ch - 'a'];
            }
            node.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        return isMatched(searchWord, 0, searchWord.length(), root, 0);
    }

    public boolean isMatched(String searchWord, int i, int n, Node node, int diff) {
        if (i == n) {
            return diff == 1 && node.isEnd;
        }
        if (diff > 1) {
            return false;
        }
        for (Node it : node.next) {
            if (it != null) {
                if (it == node.next[searchWord.charAt(i) - 'a']) {
                    if (isMatched(searchWord, i + 1, n, it, diff)) {
                        return true;
                    }
                } else {
                    if (isMatched(searchWord, i + 1, n, it, diff + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    class Node {
        boolean isEnd;
        Node[] next;

        public Node() {
            this.next = new Node[26];
            isEnd = false;
        }
    }
}