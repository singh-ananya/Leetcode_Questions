class Solution {
    int count;
    public int totalNQueens(int n) {
        count=0;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        backtracking(board,0,n);
        return count;
    }
    public boolean isSafe(char[][] board, int row, int col, int n){

        // check column on upper side
        for (int i = row; i >= 0; i--){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        // check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        // check upper diagonal on right side
        for (int i = row, j = col; i >= 0 && j < n; i--, j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public void backtracking(char board[][],int row,int n){
        if(row==n){
            count++;
            return;
        }
        
        for(int col=0;col<n;col++){
            if(isSafe(board,row,col,n)){
                board[row][col]='Q';
                backtracking(board,row+1,n);
                board[row][col]='.';
            }
        }
    }
}