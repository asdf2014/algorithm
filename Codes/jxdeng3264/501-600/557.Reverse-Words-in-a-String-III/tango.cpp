class Solution {
public:
    string reverseWords(string s) {
        string ret = s;
        // revert all
        int slen = ret.length();

        cout<<ret<<endl;
        int sp = 0;
        int ep = -1;
        while (1) {
            if (sp >= slen) break;
            sp = ep + 1;
            //找第一个字母
            while (ret[sp] == ' ')
                ++sp;
            ep = sp;
            while (ep < slen -1 && ret[ep+1] != ' ')
                ++ep;
            //cout<<"len:"<<(ep-sp+1)<<endl;
            for (int i = sp; i < sp+(ep-sp+1)/2; ++i)
            {
                //cout<<"ret["<<i<<"]"<<ret[i]<<" "<<ret[ep-i-sp]<<endl;
                std::swap(ret[i], ret[ep-(i-sp)]);
            }
            
            //cout<<sp<<" "<<ep<<" "<<ret<<endl;
            
            sp = ep + 1;
        }

        return ret;
    }
};