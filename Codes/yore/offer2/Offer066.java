package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/8 10:40
 * @description
 */
public class Offer066 {
    class MapSum {
        Trie t;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            t = new Trie();
        }

        public void insert(String key, int val) {
            t.insert(key, val);
        }

        public int sum(String prefix) {
            return t.getSum(prefix);
        }

        class Trie {
            private Trie[] child;
            private int count;
            private boolean isEnd;

            public Trie() {
                this.child = new Trie[26];
                this.count = 0;
                this.isEnd = false;
            }

            public void insert(String word, int cnt) {
                Trie node = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (node.child[c - 'a'] == null) {
                        node.child[c - 'a'] = new Trie();
                    }
                    node = node.child[c - 'a'];
                }
                node.count = cnt;
                node.isEnd = true;
            }


            public int getSum(String prefix) {
                Trie node = this;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    if (node.child[c - 'a'] == null) {
                        return 0;
                    }
                    node = node.child[c - 'a'];
                }
                return process(node);
            }

            public int process(Trie node) {
                int sum = 0;
                if (node.isEnd) {
                    sum += node.count;
                }
                for (Trie t : node.child) {
                    if (t != null) {
                        sum += process(t);
                    }
                }
                return sum;
            }
        }
    }

}
