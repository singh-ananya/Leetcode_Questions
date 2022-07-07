class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(Math.abs(a-x)==Math.abs(b-x))
                return a-b;
            return Math.abs(a-x)-Math.abs(b-x);
        }); 
        for(int i:arr){
            pq.add(i);
        }
        List<Integer> ans=new ArrayList<>();
        while(k-->0){
            ans.add(pq.remove());
        }
        Collections.sort(ans);
        return ans;
    }
}