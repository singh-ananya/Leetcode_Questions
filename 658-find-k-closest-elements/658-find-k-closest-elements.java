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
        PriorityQueue<Pair> MaxHeap = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            MaxHeap.add(new Pair(Math.abs(arr[i]-x),arr[i]));
            if(MaxHeap.size()>k){
                MaxHeap.poll();
            }
        }
        while(MaxHeap.size()>0){
            ans.add(MaxHeap.poll().num);
        }
        Collections.sort(ans);//klogk time
        return ans;
    }
}