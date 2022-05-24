class Solution {
    int dirs[][]={{1,0},{0,1},{-1,0},{0,-1}};
    public int countBattleships(char[][] board) {
       int count=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    dfs(board,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] board,int i,int j){
        board[i][j]='.';
        for(int dir[]:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]!='.'){
                dfs(board,x,y);
            }
        }
    }
}