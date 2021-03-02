class Solution {
    public boolean judgeCircle(String moves) {
         int level = 0;
        int vertical = 0;
        char[] array = moves.toCharArray();
        for (char character : array) {
            switch (character) {
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'L':
                    level++;
                    break;
                case 'R':
                    level--;
                    break;
                default:
            }
        }
        return (level == 0 && vertical == 0);
    }
}