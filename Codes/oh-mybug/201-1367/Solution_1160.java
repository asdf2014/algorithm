import org.junit.Test;

/**
 * ClassName: Solution_160
 * Date:      2020/4/5 10:22
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
1160. 拼写单词
给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），
那么我们就认为你掌握了这个单词。
注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。
示例 1：
    输入：words = ["cat","bt","hat","tree"], chars = "atach"
    输出：6
解释：
    可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。

示例 2：
    输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
    输出：10
解释：
    可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
提示：
    1 <= words.length <= 1000
    1 <= words[i].length, chars.length <= 100
    所有字符串中都仅包含小写英文字母

 */
public class Solution_1160 {
    @Test
    public void test(){
        String chars = "hcat";
        String[] words = {"cat","bt","hat","tree","atach"};
        System.out.println(countCharacters(words, chars));
    }
    public int countCharacters(String[] words, String chars) {
        int[] charsArray = new int[26];
        int[] wordArray;
        int sum = 0;
        Boolean isPlus;
        for (char c:chars.toCharArray()){
            charsArray[c-'a'] ++;
        }
        for (String word: words){
            isPlus = true;
            wordArray = new int[26];
            for (char c:word.toCharArray()){
                wordArray[c-'a'] ++;
            }
            for (int i = 0; i < 26; i++){
                if (charsArray[i] - wordArray[i] < 0){
                    isPlus = false;
                    break;
                }
            }
            if (isPlus)
                sum += word.length();
        }
        return sum;
    }
}
