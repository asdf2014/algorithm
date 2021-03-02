class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> keySet = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            keySet.add(J.charAt(i));
        }
        for (int j = 0; j < S.length(); j++) {
            if (keySet.contains(S.charAt(j))) {
                count++;
            }
        }
        return count;
    }
}