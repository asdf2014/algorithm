class Solution {
public:
	int shipWithinDays(vector<int>& weights, int D) {
		int s = 0;
		for (int i = 0; i < weights.size(); ++i)    s += weights[i];

		int lower = (s%weights.size()==0)? s/weights.size() : (s/weights.size() + 1);
		int i = 0;
		for (i = lower; ; ++i)
		{
			int ts = 0;
			int td = 0;
			bool expand = false;
			for (int j = 0; j < weights.size(); ++j)
			{
				if (ts + weights[j] <= i) 
				{
					ts += weights[j];
				}
				else 
				{
					td++;
					ts = weights[j];
				}

				if (td > D) break;

				if (ts > i) {
					expand = true;
					break;
				}

			}

			if (expand) continue;

			if (ts) td++;

			if (td <= D)    return i;

		}

		return i;
	}
};
