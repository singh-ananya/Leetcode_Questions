class Solution {
    public int uniquePaths(int m, int n) {
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=-1;
            }
        }
        return memo(ans,m-1,n-1);
    }
    public int memo(int dp[][],int m,int n){
        if(m==0 || n==0){
            dp[m][n]=1;
            return dp[m][n];
        }
        
        if(dp[m][n]!=-1)
            return dp[m][n];
        int res=0;
        res=memo(dp,m-1,n)+memo(dp,m,n-1);
        dp[m][n]=res;
        return dp[m][n];
    }
}