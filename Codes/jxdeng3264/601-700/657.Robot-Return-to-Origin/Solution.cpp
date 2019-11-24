class Solution {
public:
    bool judgeCircle(string moves) {
        int nu = 0;
        int nd = 0;
        int nl = 0;
        int nr = 0;
        for (int i = 0; i < moves.length(); ++i) {
            if (moves[i] == 'U')    nu++;
            if (moves[i] == 'D')    nd++;
            if (moves[i] == 'L')    nl++;
            if (moves[i] == 'R')    nr++;
        }

        if (nu == nd && nl == nr)   return true;
        return false;
    }
};