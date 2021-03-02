class Solution {
public:
    bool isHappy(int n) {
        set<int> st;
        int sum = 0;
        while(sum!=1){
            sum=0;
            while(n!=0){
                sum += pow((n%10),2);
                n/=10;
            }
            if(!st.count(sum)){
                st.insert(sum);
            }else{
                return false;
            }
            n = sum;
        }
        return true;
    }
};