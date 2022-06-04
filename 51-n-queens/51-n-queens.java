class Solution {
    public void placeQueen(int row, char[][]board, List<List<String>>ans){
        if(row == board.length){
            ans.add(construct(board));
            return;
        }
        
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                placeQueen(row+1, board, ans);
                board[row][col] = '.';
            }
        }
    }
    
    
    public boolean isSafe(char[][]board, int row, int col){
        int i;
        int j;
        for(i=row-1,j=col; i>=0; i--){
            if(board[i][j]=='Q')
                return false;
        }
        for(i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q')
                return false;
        }
        for(i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q')
                return false;
        }
        return true;
    } 
    static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        placeQueen(0, board, ans);
        return ans;
    }
}