class Solution {
public:
    vector<int> sortedSquares(vector<int>& A) {
        vector<int> ret;
        if (A.size() == 0) return ret;
        int min_val = std::abs(A[N-1]);
        int min_idx = N - 1;
        int N = A.size();
        for (int i = N-1; i >= 0; --i)
        {
            if (std::abs(A[i]) > min_val)
                break;
            min_val = A[i];
            min_idx = i;  
        }

        ret.push_back(A[min_idx]*A[min_idx]);
        int left = min_idx -1;
        int right = min_idx + 1;
        while (left >= 0 || right < N)
        {
            if (left >= 0 && right < N)
            {
                if (std::abs(A[left]) < std::abs(A[right]))
                {
                    ret.push_back(A[left]*A[left]);
                    left--;
                }
                else 
                {
                    ret.push_back(A[right]*A[right]);
                    right++;
                }
            }
            else if (left>=0)
            {
                ret.push_back(A[left] *A[left]);
                left--;
            }
            else if (right <N)
            {
                ret.push_back(A[right]*A[right]);
                right++;
            }
        }
        return ret;
    }
};