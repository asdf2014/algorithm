package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/7 10:52
 * @description
 */
public class Offer063 {

    public static void main(String[] args) {
        Offer063 o = new Offer063();
        List<String> dictionary = new ArrayList<String>(){{
            add("cat");
            add("bat");
            add("rat");
        }};
        String sentence = "the cattle was rattled by the battery";
        System.out.println(o.replaceWords(dictionary,sentence));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (String r : dictionary) {
            root.insert(r);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(root.replace(word));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        public String replace(String word) {
            StringBuilder sb = new StringBuilder("");
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] != null) {
                    node = node.children[c - 'a'];
                    sb.append(c);
                    if (node.isEnd) {
                        return sb.toString();
                    }
                } else {
                    break;
                }
            }
            return word;
        }
    }
}
