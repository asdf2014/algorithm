// ProblemID: 1006
// Author: tango
class Solution {
public:
    int clumsy(int N) {
        if (N==1)   return 1;
        // 操作用负数表示
        int oper = -4; 
        stack<int>  s;
        s.push(N);
        
        for (int i = N-1; i>=1; --i) {
            if (oper < -2)  {// * or /
                int n1 = s.top();
                s.pop();
                int res = 0;
                if (oper == -4)  res = n1*i;
                else if(oper == -3) res = n1/i;
               
                s.push(res);
            } 
            else {
                s.push(oper);
                s.push(i);
            }
            
            //next oper 
            oper++;
            if (oper==0)    oper = -4;
           
        }

        stack<int> rs;
        while(!s.empty())
            rs.push(s.top()); s.pop();
        
        // 1+2+3
        while (rs.size()!=1) {
            int n1 = rs.top();
            rs.pop();
            oper = rs.top();
            rs.pop();
            int n2 = rs.top();
            rs.pop();
            int res = 0;
            
            if (oper == -1) res = n1-n2;
            if (oper == -2) res = n2+n1;
            rs.push(res);
        }
        
        return rs.top();
    }
};
