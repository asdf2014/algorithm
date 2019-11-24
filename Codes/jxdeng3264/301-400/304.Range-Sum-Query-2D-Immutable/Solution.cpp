/*
f(n,m) = matrix(n,m)f(n-1,m) + f(n, m-1) - f(n-1, m-1);
*/
class NumMatrix {
public:
    NumMatrix(vector<vector<int>> matrix) {
        m_matrix = matrix;
        for (int i=1; i<m_matrix.size() && m_matrix[i].size()>0; ++i)
        {
            m_matrix[i][0] += m_matrix[i-1][0];
        }
        
        
        for (int i=1; m_matrix.size()>0 && i<m_matrix[0].size(); ++i)
        {
            m_matrix[0][i] += m_matrix[0][i-1];
        }
        
        for (int i=1; i<m_matrix.size(); ++i)
        {
            for (int j=1; j<m_matrix[0].size(); ++j)
            {
                m_matrix[i][j] += m_matrix[i-1][j] + m_matrix[i][j-1] - m_matrix[i-1][j-1];
            }
        }
    }

    /*
    formula
    sum = f(r2,c2) + f(r1-1, c1-1) - f(r2,c1-1) - f(r1-1, c2);
    sum = m_matrix[r2][c2] + lr -left - up
    */
    int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1>=m_matrix.size() || row2 >=m_matrix.size() )
            return 0;
        if (col1 >= m_matrix[0].size() || col2 >= m_matrix[0].size())
            return 0;
        int lr = 0;
        int left = 0;
        int up = 0;
        if (row1==0 || col1==0)
            lr = 0;
        else
        {
            lr = m_matrix[row1-1][col1-1];
        }

        if (col1==0)
        {
            left = 0;
        }
        else
        {
            left = m_matrix[row2][col1-1];
        }

        if (row1==0)
        {
            up = 0;
        }
        else
        {
            up = m_matrix[row1-1][col2];
        }
        return (m_matrix[row2][col2]+lr-left-up);
    }

    vector<vector<int>> m_matrix;
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
