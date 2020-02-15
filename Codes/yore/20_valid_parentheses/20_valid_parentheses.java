public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Set<Character> set = new HashSet<>();
    set.add('(');
    set.add('[');
    set.add('{');
    char tmp;
    for (int i = 0; i < s.length(); i++) {
        tmp = s.charAt(i);
        if (set.contains(tmp)) {
            stack.push(tmp);
        } else {
            if (stack.empty() || tmp - stack.peek()  > 2 || tmp - stack.peek()  < 0) {
                return false;
            }
            stack.pop();
        }
    }
    return stack.size() == 0;
}
