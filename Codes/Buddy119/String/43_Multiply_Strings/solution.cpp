class Solution {
public:
    string multiply(string num1, string num2) {
        int size1 = num1.size();
        int size2 = num2.size();
        string res(size1+size2, '0');
        for(int i = size1 - 1; i >= 0; i--){
            for(int j = size2 - 1; j >= 0; j--){
                int sum = res[i+j+1] - '0' + (num1[i] - '0') * (num2[j] - '0');
                res[i+j] += sum / 10;
                res[i+j+1] = sum % 10 + '0';
            }
        }
        for(int i = 0; i < res.size(); i++){
            if(res[i] != '0' || i == res.size() - 1) return res.substr(i);
        }
        return "";
    }
};
