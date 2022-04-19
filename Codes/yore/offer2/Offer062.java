package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/7 10:32
 * @description
 */
public class Offer062 {
    class Trie {
        public Trie[] children;
        boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        /**
         * Inserts a word into the trie.
         */
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

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        public Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return null;
                }
                node = node.children[c - 'a'];
            }
            return node;
        }
    }
}
