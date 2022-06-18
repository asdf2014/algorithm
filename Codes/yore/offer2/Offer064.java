package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/7 13:33
 * @description
 */
public class Offer064 {
    class MagicDictionary {
        private String[] dictionary;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            this.dictionary = null;
        }

        public void buildDict(String[] dictionary) {
            this.dictionary = dictionary;
        }

        public boolean search(String searchWord) {
            boolean result = false;
            for (int i = 0; i < dictionary.length; i++) {
                result = getResult(searchWord, dictionary[i]);
                if (result) {
                    return true;
                }
            }
            return false;
        }

        public boolean getResult(String word, String dic) {
            if (word.length() != dic.length()) {
                return false;
            }
            int unsame = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != dic.charAt(i)) {
                    unsame++;
                }
                if (unsame > 1) {
                    return false;
                }
            }
            if (unsame == 0) {
                return false;
            }
            return true;
        }

    }
}
