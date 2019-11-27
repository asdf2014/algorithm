class Solution {
public:
    int hIndex(vector<int>& citations) {
        //sort(citations.begin(), citations.end());
        int m = 0;
        int M = 0;
        int L = 0;
        int N = citations.size();
        int H = N - 1;
        while (L <= H) {
            M = L + (H - L)/2;
            m = std::max(m, std::min(citations[M], N - M));
            if (citations[M] < N-M) 
                L = M + 1;
            else
                H = M - 1;

        }
        return m;
    }
};