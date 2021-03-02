class Solution {
public:
    int minIncrementForUnique(vector<int>& A) {
        if(A.size()<=1){
				return 0;
		}
        sort(A.begin(),A.end(),less<int>());
			int count=0;
			int same_num=0;
			vector<int>::iterator iter = A.begin();
			int tmp =*iter++;
			int record_top=tmp;
			for(; iter!=A.end(); ++iter) {
				if(*iter == tmp) {
					same_num++;
					count += same_num;
					++record_top;
				} else {
					same_num = 0;
					if(record_top >= (*iter)) {
						count +=(record_top - *iter + 1) ;
						++record_top;
					} else {
						record_top = *iter;
					}
				}
			}
			return count;
    }
};
