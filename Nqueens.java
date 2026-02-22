class Solution {
    public List<List<String>> solveNQueens(int n) {

    List<List<String>> ans = new ArrayList<>();
    char[][] board = new char[n][n];

    for (int i = 0; i < n; i++) {
        Arrays.fill(board[i], '.');
    }

    checkSol(0,ans,board,n);
    return ans;
        
    }

    private void checkSol(int col, List<List<String>> ans, char[][] board, int n)
    {
        if(col==n)
        {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int row=0; row<n;row++)
        {
            if (isSafe(row,col,board,n))
            {
                board[row][col]='Q';

                checkSol(col+1,ans,board,n);

                board[row][col]='.';
            }
        }
    }

        public boolean isSafe(int row, int col, char[][] board, int n) {
        // Check left in the same row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check lower-left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Return true if it's safe to place
        return true;
    }


}