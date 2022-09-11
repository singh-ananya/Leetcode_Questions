class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int engineers[][]=new int[n][2];
        for(int i=0;i<n;i++){
            engineers[i][0]=efficiency[i];
            engineers[i][1]=speed[i];
        }
        long ans=0;
        long sum=0;
        //sort efficiency descending
        Arrays.sort(engineers,(a,b)->{
            return b[0]-a[0];
        });
         //now when we traverse we can always take k elements as 
     //taking less won't increase our sum but it would be disadvantageous
     //and for every efficiency we check whwether sum is max or not 
     //as efficieny is decreasing as we move 
     //any prev speed summed isn't different so we can remove lowest speed
     //to get max sum and atmost k speeds are used including curr speed
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            sum+=engineers[i][1];
            if(pq.size()==k){
                sum-=pq.remove();
            }
            pq.add(engineers[i][1]);
            ans=Math.max(ans,(long)engineers[i][0]*sum);
        }
        return (int)(ans%(int)(1e9+7));
    }
}