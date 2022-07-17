class Solution {
    int knightMoves[][]={{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    public double knightProbability(int n, int k, int row, int col) {
        //return rec(n,row,col,k);
        Double[][][] dp=new Double[k+1][n][n];
        return memo(n,row,col,k,dp);
    }
    public double rec(int n,int row,int col,int k){
        if(row<0 ||row>=n||col<0 ||col>=n)
            return 0;
        if(k==0)
            return 1;
        double count=0;
        for(int dir[]:knightMoves){
            int r=row+dir[0];
            int c=col+dir[1];
            double prob=(rec(n,r,c,k-1))/8;
            count+=prob;
        }
        return count;
    }
    public double memo(int n,int row,int col,int k,Double[][][] dp){
        if(row<0 ||row>=n||col<0 ||col>=n)
            return 0;
        if(k==0)
            return 1;
        if(dp[k][row][col]!=null)
            return dp[k][row][col];
        double count=0;
        for(int dir[]:knightMoves){
            int r=row+dir[0];
            int c=col+dir[1];
            double prob=(memo(n,r,c,k-1,dp))/8;
            count+=prob;
        }
        return dp[k][row][col]=count;
        
    }
}