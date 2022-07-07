class Solution {
    public class Pair{
        int key;
        int num;
        Pair(int key,int num){
            this.key = key;
            this.num = num;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> MaxHeap = new PriorityQueue<>(new Comparator<Pair>(){
           public int compare(Pair p1,Pair p2){
               if(p1.key == p2.key){
                   return p2.num - p1.num;
               }
               else{
                   return p2.key - p1.key;
               }
           } 
        });
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
        Collections.sort(ans);
        return ans;
    }
}