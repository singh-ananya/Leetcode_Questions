class Solution {
    public int minPathSum(int[][] grid) {
       int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        //return rec(grid,m-1,n-1);
        return memo(grid,dp,m-1,n-1);
    }
    //recursive sol but it will tle
    /*public int rec(int[][] grid,int m,int n){
        if(m==0 && n==0)
            return grid[m][n];
        if(m<0 || n<0)
            return Integer.MAX_VALUE;
        int ans=0;
        ans=grid[m][n]+Math.min(rec(grid,m-1,n),rec(grid,m,n-1));
        return ans;
    }*/
    public int memo(int[][] grid,int[][] dp,int m,int n){
        if(m==0 && n==0)
             return dp[m][n]=grid[m][n];
        
        if(m<0 || n<0)
            return Integer.MAX_VALUE;
        
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        
        int ans=0;
        ans=grid[m][n]+Math.min(memo(grid,dp,m-1,n),memo(grid,dp,m,n-1));
        dp[m][n]=ans;
        return dp[m][n];
    }
}