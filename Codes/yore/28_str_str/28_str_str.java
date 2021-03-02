class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
	
	public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int needleLength = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            int point = i;
            if (haystack.charAt(point++) == needle.charAt(j++)) {
                while (j < needleLength && point < haystack.length()) {
                    if (haystack.charAt(point) != needle.charAt(j)) {
                        break;
                    } else {
                        point++;
                        j++;
                    }
                }
                if (j == needleLength) {
                    return i;
                }
            }

        }
        return -1;
    }
}