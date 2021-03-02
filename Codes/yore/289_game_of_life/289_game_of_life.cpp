class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
			if(board.size()<= 0) {
				return;
			} else {
				vector<vector<int>> vec(board);
				for(vector<vector<int>>::size_type st= 0; st!=board.size(); ++st) {
					for(vector<vector<int>>::size_type sz= 0; sz!=board[0].size(); ++sz) {
						if(is_alive(vec,st,sz)) {
							board[st][sz] = 1;
						} else {
							board[st][sz] = 0;
						}
					}
				}
			}
		}

		bool is_alive(vector<vector<int>>& board,int index_r,int index_c) {
			int r_num = board.size();
			int c_num = board[0].size();
			int count =0;
			if(index_r-1>=0 && index_c-1>=0) {
				if(board[index_r-1][index_c-1]==1) {
					count++;
				}
			}
			if(index_r-1>=0) {
				if(board[index_r-1][index_c]==1) {
					count++;
				}
			}
			if(index_r-1>=0 && index_c+1<c_num) {
				if(board[index_r-1][index_c+1]==1) {
					count++;
				}
			}
			if( index_c-1>=0) {
				if(board[index_r][index_c-1]==1) {
					count++;
				}
			}
			if(index_c+1<c_num) {
				if(board[index_r][index_c+1]==1) {
					count++;
				}
			}
			if(index_r+1 < r_num && index_c-1>=0) {
				if(board[index_r+1][index_c-1]==1) {
					count++;
				}
			}
			if(index_r+1<r_num) {
				if(board[index_r+1][index_c]==1) {
					count++;
				}
			}
			if(index_r+1<r_num && index_c+1<c_num) {
				if(board[index_r+1][index_c+1]==1) {
					count++;
				}
			}

			if(board[index_r][index_c] ==1) {
				if(count ==2 || count ==3) {
					return true;
				} else {
					return false;
				}

			} else {
				if(count ==3) {
					return true;
				} else {
					return false;
				}
			}
		}
};
