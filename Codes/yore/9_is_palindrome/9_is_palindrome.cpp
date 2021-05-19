bool isPalindrome(int x) {
    string str = to_string(x);
		cout << str << endl;
		string::size_type begin = 0;
		string::size_type end = str.size()-1;
		while(begin < end) {
			if(str[begin++] != str[end--]) {
				return false;
			}
		}
		return true;
}