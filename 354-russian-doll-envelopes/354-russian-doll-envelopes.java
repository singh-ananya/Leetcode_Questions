class Solution {
    public int maxEnvelopes(int[][] arr) {
         int n = arr.length;
        Arrays.sort(arr,(p,q)-> p[0]==q[0] ? q[1]-p[1] : p[0]-q[0]);
        
         int dp[] = new int[arr.length];
    int len = 0;
    for(int[] envelope : arr){
        int index = binarySearch(dp, 0, len, envelope[1]);
        
        dp[index] = envelope[1];
        if(index == len)
            len++;
    }
    return len;
        
    }
    
    public int binarySearch(int[] dp,int si, int ei, int target) {
         while(si<ei){
             int mid = si+(ei-si)/2;
             if(dp[mid] == target) return mid;
             else if(dp[mid] > target) ei = mid;
             else  si = mid+1;
         }
        return si;
    }
}