class Solution {
 public:
  string addStrings(string num1, string num2) {
    int cur_pos_num1 = num1.size() - 1;
    int cur_pos_num2 = num2.size() - 1;
    string res = "";
    int curry = 0;
    int new_res;

    while (cur_pos_num1 >= 0 || cur_pos_num2 >= 0 || curry != 0) {
      // int x = cur_pos_num1>=0 ? num1[cur_pos_num1]-'0' : 0;
      // int y = cur_pos_num2>=0 ? num2[cur_pos_num2]-'0' : 0;
      // new_res = x + y + curry;
      new_res = (cur_pos_num1 >= 0 ? num1[cur_pos_num1] - '0' : 0) +
                (cur_pos_num2 >= 0 ? num2[cur_pos_num2] - '0' : 0) + curry;
      curry = new_res / 10;
      res.push_back(new_res % 10 + '0');

      cur_pos_num1--;
      cur_pos_num2--;
    }
    reverse(res.begin(), res.end());
    return res;
  }
};