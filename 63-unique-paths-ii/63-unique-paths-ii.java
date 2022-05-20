class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
//         int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
//         for (int i = 0; i < dp.length; i++) {
//             for (int j = 0; j < dp[0].length; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         return solve(obstacleGrid, 0, 0, dp);
//     }

//     public int solve(int[][] arr, int sr, int sc, int[][] dp) {
//         if (sr < 0 || sc < 0 || sr == arr.length || sc == arr[0].length || arr[sr][sc] == 1) {
//             return 0;
//         }
//         if (sr == arr.length - 1 && sc == arr[0].length - 1) {
//             return 1;
//         }
//         if (dp[sr][sc] == -1) {
//             dp[sr][sc] = solve(arr, sr + 1, sc, dp) + solve(arr, sr, sc + 1, dp);
//         }
//         return dp[sr][sc];
//     }
        int m = arr.length ;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
             
                if(arr[i][j]==1)dp[i][j] = 0;
				
                else if(i==0 && j==0) dp[i][j]=1;
				
                else{
                    int up=0, left =0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j] = left+up;
                }
            }
        }
            return dp[m-1][n-1];
    }
}