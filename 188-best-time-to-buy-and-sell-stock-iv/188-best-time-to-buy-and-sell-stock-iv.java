// class Solution {
//     public int maxProfit(int k, int[] prices) {
        
//         int n = prices.length;
//         int cap = k; // no of transactions allowed
//         int buy = 1; // can buy or not
//         Integer[][][] dp = new Integer[n][2][k+1];
//         return maxProfit(0, buy, cap, prices, n, dp);
//     }
    
//     private int maxProfit(int i, int buy, int cap, int[] prices, int n, Integer[][][] dp){
        
//         if(i == n || cap == 0) return 0;
        
//         if(dp[i][buy][cap] != null) return dp[i][buy][cap];
//         // if can buy new stack else sell
//         if(buy == 1){
//             return dp[i][buy][cap] = Math.max(-prices[i] + maxProfit(i+1, 0, cap, prices, n, dp)
//                              , 0 + maxProfit(i+1, 1, cap, prices, n, dp));                     
//         }
//         else{
//             return dp[i][buy][cap] = Math.max(prices[i] + maxProfit(i+1, 1, cap-1, prices, n, dp)
//                              , 0 + maxProfit(i+1, 0, cap, prices, n, dp));
//         }
//     }
// }



// Tabulation Solution
// TC - O(n*2*k) , SC - O(n*2*k)
class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i = n-1; i >= 0; i--){
            for(int buy = 0; buy < 2; buy++){
                for(int cap = 1; cap < k+1; cap++){
                    if(buy == 1){
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap]
                                                            , 0 + dp[i+1][1][cap]);                     
                        }
                    else{
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1]
                                                            , 0 + dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}