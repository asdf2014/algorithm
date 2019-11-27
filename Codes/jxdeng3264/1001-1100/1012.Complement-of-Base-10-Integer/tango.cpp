class Solution {
public:
	int bitwiseComplement(int N) {
		if (N==0)   return 1;

		int tn = N;
		tn ^= 0xFFFFFFFF;
		unsigned int cmp = 0x80000000;
		while (tn & cmp)
		{
			tn ^= cmp;
			cmp >>= 1;
		}

		return tn;
	}
};
