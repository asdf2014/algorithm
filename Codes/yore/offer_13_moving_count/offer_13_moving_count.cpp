class Solution {
public:
    int movingCount(int m, int n, int k) {
        int count  = 0;
        int a[100][100] = {0};
        cal(0, 0, m, n, k, a);
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(a[i][j] == 1) {
                    ++count;
                }
            }
        }
        return count;
    }

    void cal(int index_r, int index_c, int m, int n, int k, int (&a)[100][100]) {
        a[index_r][index_c] = 1;
        if(index_r - 1 >= 0) {
            if(a[index_r - 1][index_c] == 0 && check(index_r - 1, index_c, k)) {
                a[index_r - 1][index_c] = 1;
                cal(index_r - 1, index_c, m, n, k, a);
            }
        }
        if( index_c - 1 >= 0) {
            if(a[index_r ][index_c - 1] == 0 && check(index_r, index_c - 1, k)) {
                a[index_r ][index_c - 1] = 1;
                cal(index_r, index_c - 1, m, n, k, a);
            }
        }
        if(index_r + 1 < m) {
            if(a[index_r + 1][index_c] == 0 &&  check(index_r + 1, index_c, k)) {
                a[index_r + 1][index_c] = 1;
                cal(index_r + 1, index_c, m, n, k, a);
            }
        }
        if( index_c + 1 < n) {
            if(a[index_r][index_c + 1] == 0 && check(index_r, index_c + 1, k)) {
                a[index_r][index_c + 1] = 1;
                cal(index_r, index_c + 1, m, n, k, a);
            }
        }
    }

    bool check(int m, int n, int k) {
        int sum = 0;
        while(m != 0) {
            sum += (m % 10);
            m /= 10;
        }
        while(n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum <= k;
    }
};