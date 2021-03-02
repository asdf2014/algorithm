impl Solution {
    pub fn solve(board: &mut Vec<Vec<char>>) {
        if board.len() != 0 {
            let (m, n) = (board.len(), board[0].len());
            let list = board
                .iter()
                .enumerate()
                .map(|(i, row)| {
                    row.iter()
                        .enumerate()
                        .filter(|(j, x)| {
                            (i == 0 || j == &0 || i == m - 1 || *j == n - 1) && **x == 'O'
                        })
                        .map(|(j, _x)| (i, j))
                        .collect::<Vec<(usize, usize)>>()
                })
                .flatten()
                .collect::<Vec<(usize, usize)>>();
            list.iter().for_each(|(x, y)| {
                find_list(board, *x, *y, m, n);
            });
            fn find_list(board: &mut Vec<Vec<char>>, x: usize, y: usize, m: usize, n: usize) {
                board[x][y] = 'D';
                if x < m - 1  {
                    if board[x + 1][y] == 'O' {
                        find_list(board, x + 1, y, m, n);
                    }
                }
                if x>0{
                    if board[x - 1][y] == 'O' {
                        find_list(board, x - 1, y, m, n);
                    }
                }
                if y<n-1{
                    if board[x][y + 1] == 'O' {
                        find_list(board, x, y + 1, m, n);
                    }
                }
                if y>0{
                    if board[x][y - 1] == 'O' {
                        find_list(board, x, y - 1, m, n);
                    }
                }
            }
            for i in 0..m {
                for j in 0..n {
                    if board[i][j] != 'D' {
                        board[i][j] = 'X'
                    } else {
                        board[i][j] = 'O'
                    }
                }
            }
        }
    }
}
