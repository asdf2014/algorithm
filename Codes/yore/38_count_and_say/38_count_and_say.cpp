class Solution {
public:
    string countAndSay(int n) {
        	int number=1;
			string s = to_string(number);
			if(n==1){
				return "1";
			}
			int count =1;
			string result;
			while(--n) {
				result ="";count =1;
				for(string::size_type st = 0; st!=s.size(); ++st) {
					if(st+1<s.size() && s[st]==s[st+1]) {
						count++;
					} else {
						result += (to_string(count) + s[st]);
						count =1;
					}
				}
				cout << result << endl;
				s= result;
			}
			return result;
    }
};