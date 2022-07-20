package com.yore.medium;

import java.util.List;

/**
 * @author Yore
 * @date 2022/7/8 9:35
 * @description
 */


public class Number648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        buildPrefixTree(root, dictionary);
        StringBuilder sb = new StringBuilder("");
        String[] words = sentence.split(" ");
        for (String word : words) {
            sb.append(searchPrefix(word, root));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void buildPrefixTree(Node root, List<String> dictionary) {
        for (String dic : dictionary) {
            char[] chs = dic.toCharArray();
            Node node = root;
            for (char ch : chs) {
                int index = ch - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new Node();
                }
                node = node.next[index];
            }
            node.end = true;
        }
    }

    public String searchPrefix(String word, Node root) {
        if (root.next[word.charAt(0) - 'a'] == null) {
            return word;
        }
        StringBuilder sb = new StringBuilder("");
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                return word;
            }
            sb.append(ch);
            if (node.next[ch - 'a'].end) {
                return sb.toString();
            }
            node = node.next[ch - 'a'];
        }
        return word;
    }

    class Node {
        boolean end;
        Node[] next;

        public Node() {
            next = new Node[26];
        }
    }
}
