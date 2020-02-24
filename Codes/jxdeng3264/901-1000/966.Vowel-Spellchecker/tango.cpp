class Solution {
public:
    vector<string> spellchecker(vector<string>& wordlist, vector<string>& queries) {
        vector<string> ret;
        if (!wordlist.size() || !queries.size())   return ret;

        for (int i = 0; i < queries.size(); ++i) {
            string &q = queries[i];
            if (find(wordlist.begin(), wordlist.end(), q) != wordlist.end()) {
                ret.push_back(q); continue;
            }
            string rc,rv;
            int j = 0;
            for (j = 0; j < wordlist.size(); ++j) 
            {
                string &s = wordlist[j];
                if (q.size() != s.size())
                    continue;
                // 大小写检查
                int k = 0;
                for (k = 0; k < q.length(); ++k)
                {
                    char cs = tolower(s[k]);
                    char cq = tolower(q[k]);
                    if (cs != cq)   break;   
                }
                if (k==q.length()) {
                    rc = s;
                    break;
                }

                for (k = 0; k < q.length(); ++k)
                {
                    char cs = tolower(s[k]);
                    char cq = tolower(q[k]);
                    if (cs != cq) {
                        if (isVowel(cs) && isVowel(cq)) continue;
                        else    break;// 
                    }
                }
                if (k==q.length() && rv.length() == 0) {
                    rv = s;
                }
            }

            if (rc.length()) ret.push_back(rc);
            else if (rv.length()) ret.push_back(rv);
            else ret.push_back("");
        }
        return ret;
    }

    bool isVowel(char c)
    {
        return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' ||
                c == 'I' || c == 'o' || c == 'O' ||c == 'u' || c == 'U' );
    }
};