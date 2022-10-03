class Solution {
    public int minCost(String colors, int[] neededTime) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0;
        int n = colors.length();
        int min_cnt = 0;
        
        while (i < n){
            
            while (i < n-1 && colors.charAt(i) == colors.charAt(i+1)){
                pq.offer(neededTime[i]);
                i++;
            }
            
            pq.offer(neededTime[i]);
            i++;
            while (pq.size() > 1) min_cnt += pq.poll();
            pq.poll();
            
        }
        return min_cnt;
    }
}