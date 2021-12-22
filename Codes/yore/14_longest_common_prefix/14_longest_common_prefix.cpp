string longestCommonPrefix(vector<string>& strs) {
	if(strs.size() ==0) {
		return "";
	}
	bool flag = true;
	queue<char> c_queue;
	int b_index = 0;
	string result="";
	while(flag) {
		for(vector<string>::size_type st = 0; st !=strs.size(); ++st) {
			if(strs[st].size()>b_index) {
				if(st==0) {
					c_queue.push(strs[st][b_index]);
				}
				if(c_queue.back() != strs[st][b_index]) {
					flag =false;
					--b_index;
					break;
				}
			} else {
				flag =false;
				--b_index;
				break;
			}
		}
		++b_index;
	}
	while(!c_queue.empty()){
		result += c_queue.front();
		c_queue.pop();
	}
	return result.substr(0,b_index);
}