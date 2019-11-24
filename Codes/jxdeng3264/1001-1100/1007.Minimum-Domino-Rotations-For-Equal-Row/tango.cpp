// ProblemID: 1007
// Author: tango
class Solution {
public:
	int minDominoRotations(vector<int>& A, vector<int>& B) {
		int N = A.size();
		std::map<int, int> m;
		for (int i = 0; i < N; ++i) {
			if (A[i] != B[i]) {
				m[A[i]]++; m[B[i]]++;
			}
			else m[A[i]]++;
		}

		int res = N+1;
		for (int i = 1; i <= 6; ++i)
		{
			if (m.find(i)==m.end()) continue;

			if (m[i] == N)  
			{
				int tca = 0;
				int tcb = 0;
				for (int j = 0; j < N; ++j)
				{
					if (A[j]==i)    tca++;
				}

				for (int j = 0; j < N; ++j)
				{
					if (B[j]==i)    tcb++;
				}

				res = std::min(N-tca, N-tcb);
			}

		}

		if (res== N+1)  return -1;
		return res;

	}
};
