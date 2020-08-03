import java.util.*;

/**
 * ClassName:   Solution_49
 * Data:        2020/7/21
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_49 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List> map = new HashMap<>();
        int[] count = new int[26];
        for (String s: strs){
            Arrays.fill(count, 0);
            char[] chars = s.toCharArray();
            for (char c: chars)
                count[c - 'a'] ++;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++)
                stringBuilder.append(count[i]);
            String key = stringBuilder.toString();
            if (!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        // 考察了哈希函数的基本知识，只要 26 个即可
        // （小写字母ACSII 码 - 97 ）以后和质数的对应规则，这个数组的元素顺序无所谓
        // key 是下标，value 就是数值
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};

        // key 是字符串自定义规则下的哈希值
        Map<Integer, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            int hashValue = 1;

            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                hashValue *= primes[c - 'a'];
            }

            // 把单词添加到哈希值相同的分组
            if (!hashMap.containsKey(hashValue))
                hashMap.put(hashValue, new ArrayList<>());
            hashMap.get(hashValue).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        Solution_49 solution_49 = new Solution_49();
        System.out.println(solution_49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toString());
    }
}
