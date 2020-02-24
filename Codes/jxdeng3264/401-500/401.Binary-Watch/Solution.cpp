class Solution {
public:
    vector<string> readBinaryWatch(int num) {
        vector<string>  res;
        if (num==0)
        {   
            res.push_back("0:00");
            return res;
        }
        set<string>  ss;
        string hour;
        string min;
        vector<int> arrh = {1,2,4,8};
        vector<int> arrm = {1,2,4,8,16,32};
        vector<string> hours;
        vector<string>  mins;
        for (int i=0; i<=num; ++i)
        {
            getHours(hours, arrh, i, 11);
            getHours(mins, arrm, num-i, 59);
            sort(arrh.begin(), arrh.end());
            sort(arrm.begin(), arrm.end());
            //combine
            for(int j=0; j<hours.size(); ++j)
            {
                for (int k=0; k<mins.size(); ++k)
                {
                    string tmp = hours[j];
                    if (mins[k].length()==1)
                    {
                        tmp = tmp + ":" +"0" + mins[k];
                    }
                    else
                        tmp = tmp + ":" + mins[k];
                    
                    ss.insert(tmp);
                }
                
            }
            hours.clear();
            mins.clear();
        }
        
        
        for(set<string>::iterator it = ss.begin(); it!=ss.end(); ++it)
        {
            res.push_back(*it);
            
        }
        return res;
    }
    //num 亮灯的个数
    void getHours(vector<string> &nums, vector<int> arr, int k, int up)
    {
        int cnt = 0;
        string str;
        
        if(k==0 && arr.size()==4)
        {
             nums.push_back("0");
            return ;
        }   
        if(k==0 && arr.size()==6)
        {
             nums.push_back("00");
            return ;
        }   
        
       do {
            for(int i=0; i<k; ++i)
            {
                cnt += arr[i];   
            }
           
            if (cnt<=up)
            {
                intToString(cnt, str);
                nums.push_back(str);
                str.clear();
            }
            cnt = 0;
                
        } while ( std::next_permutation(arr.begin(),arr.end()));
    }
   
    void intToString(int iv, std::string &str)
    {
        if (iv==0)
        {
            str.push_back('0');
            return ;
        }
            
        while (iv)
        {
            str.push_back(iv%10+'0');
            iv /=10;
        }

        for (int i=0; i<str.length()/2; ++i)
            std::swap(str[i], str[str.length()-1]);
        
    }
};

