class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        if (!emails.size()) return 0;
        for (int i = 0; i < emails.size(); ++i) {
            //std::size_t pos_plus = emails[i].find_first_of('+', 0);
            std::size_t pos_at = emails[i].find_first_of('@', 0);
            bool has_plus_token = false;
            int space_num = 0;
            if (pos_plus != std::string::npos && pos_at != std::string::npos) {
                for (int j = 0; j < pos_at; ++j)  {
                    if (emails[i][j] == '+')    has_plus_token = true;

                    if (has_plus_token)
                    {
                        emails[i][j] = ' ';//space instead
                        space_num++;
                    } 
                }
            }
            
            if (space_num)
            {
                std::string::size_type str_len = emails[i].length();
                int cur_pos = 0;
                for (std::string::size_type k = 0; k < str_len; ++k) {
                    if (emails[i][k] != ' ')
                    {
                        emails[i][cur_pos++] = emails[i][k];
                    }
                }
                emails[i].erase(str_len-space_num, space_num);
            }
        }

        sort(emails.begin(), emails.end());
        int ret = 1;
        for (int i = 1; i < emails.size(); ++i)
        {
            if (emails[i] != emails[i-1])
                ret++;
        }

        return ret;
    }
};