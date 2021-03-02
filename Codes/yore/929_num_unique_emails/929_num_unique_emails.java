class Solution {
    public int numUniqueEmails(String[] emails) {
         Set<String> targetSet = new HashSet<>();
        for (String email : emails) {
            boolean domainFlag = false;
            boolean plusFlag = false;
            char[] emailCharArray = email.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char singleChar : emailCharArray) {
                if (domainFlag) {
                    sb.append(singleChar);
                    continue;
                }
                if (singleChar == '@') {
                    sb.append(singleChar);
                    domainFlag = true;
                    continue;
                }
                if (plusFlag && !domainFlag) {
                    continue;
                }
                if (singleChar == '+') {
                    plusFlag = true;
                    continue;
                }
                if (singleChar == '.') {
                    continue;
                }
                sb.append(singleChar);
            }
            targetSet.add(sb.toString());
        }
        return targetSet.size();
    }
}