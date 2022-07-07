class Solution {
    public class Pair implements Comparable<Pair>{
        int key;
        int num;
        Pair(int key,int num){
            this.key = key;
            this.num = num;
        }
        public int compareTo(Pair o){
            if(o.key==this.key){
                return o.num-this.num;
            }
            return o.key-this.key;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            pq.add(new Pair(Math.abs(arr[i]-x),arr[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(pq.size()>0){
            ans.add(pq.poll().num);
        }
        Collections.sort(ans);//klogk time
        return ans;
    }
}