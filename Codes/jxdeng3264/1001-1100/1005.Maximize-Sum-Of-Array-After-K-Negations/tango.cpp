// ProblemID: 1005
// Describle: 修改数组中的数K次，每一次修改为该数的相反数，问K次修改后，最大的和。
// Author: tango
class Solution {
public:
    int largestSumAfterKNegations(vector<int>& A, int K) {
        sort(A.begin(), A.end());
        int neg = 0;
        for (int i = 0; i<A.size(); ++i)
            if (A[i]<0) neg++;
        int minor = std::min(neg, K);
        for (int i = 0; i < minor; ++i)
            A[i] = -A[i];
        
        int min = A[0];
        for (int i = 0; i < A.size(); ++i)
            min = std::min(A[i], min);
        
        int sum = 0;
        for (int i = 0; i < A.size(); ++i)
            sum += A[i];
        
        if ((K-minor)%2!=0)
        {
            sum = sum - 2*min;
        }
            
        return sum;
    }
};
