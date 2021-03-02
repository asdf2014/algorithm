class Solution {
 private:
  vector<string> wordsRev;
  unordered_map<string_view, int> indices;

 public:
  int findWord(const string_view& s, int left, int right) {
    auto iter = indices.find(s.substr(left, right - left + 1));
    return iter == indices.end() ? -1 : iter->second;
  }

  bool isPalindrome(const string_view& s, int left, int right) {
    int len = right - left + 1;
    for (int i = 0; i < len / 2; i++) {
      if (s[left + i] != s[right - i]) {
        return false;
      }
    }
    return true;
  }

  vector<vector<int>> palindromePairs(vector<string>& words) {
    int n = words.size();
    for (const string& word : words) {
      wordsRev.push_back(word);
      reverse(wordsRev.back().begin(), wordsRev.back().end());
    }
    for (int i = 0; i < n; ++i) {
      indices.emplace(wordsRev[i], i);
    }

    vector<vector<int>> ret;
    for (int i = 0; i < n; i++) {
      int m = words[i].size();
      if (!m) {
        continue;
      }
      string_view wordView(words[i]);
      for (int j = 0; j <= m; j++) {
        if (isPalindrome(wordView, j, m - 1)) {
          int left_id = findWord(wordView, 0, j - 1);
          if (left_id != -1 && left_id != i) {
            ret.push_back({i, left_id});
          }
        }
        if (j && isPalindrome(wordView, 0, j - 1)) {
          int right_id = findWord(wordView, j, m - 1);
          if (right_id != -1 && right_id != i) {
            ret.push_back({right_id, i});
          }
        }
      }
    }
    return ret;
  }
};