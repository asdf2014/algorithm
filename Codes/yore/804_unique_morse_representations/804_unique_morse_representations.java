class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> result = new HashSet<>();
        Map<Character, String> info = new HashMap<>(26);
        String[] password = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            info.put(c, password[i++]);
        }
        for (String word : words) {
            char[] charArray = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char charStr : charArray){
                sb.append(info.get(charStr));
            }
            result.add(sb.toString());
        }
        return result.size();
    }
}