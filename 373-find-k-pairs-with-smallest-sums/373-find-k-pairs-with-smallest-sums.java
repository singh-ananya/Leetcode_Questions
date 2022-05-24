class Solution {
    //comparing according to the sum of elements and returning the min sum from priority queue
    public class pair implements Comparable<pair>{
        int a1;
        int a2;
        int sum;
        int idx;
        pair(int a1,int a2,int sum,int idx){
            this.a1=a1;
            this.a2=a2;
            this.sum=sum;
            this.idx=idx;
        }
        public int compareTo(pair o){
            return this.sum-o.sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<pair> pq=new PriorityQueue<>();
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){//add first nums1 length pairs to the pq
            pq.add(new pair(nums1[i],nums2[0],nums1[i]+nums2[0],0));
        }
        while(k>0 && pq.size()>0){
            pair curr=pq.remove();
            List<Integer> ans=new ArrayList<>();
            ans.add(curr.a1);
            ans.add(curr.a2);
            res.add(ans);
            int index=curr.idx;
            if(index<nums2.length-1){ //if the element which is removed has more elements after itself(from nums2 array) than add //that element into the priority queue
                pq.add(new pair(curr.a1,nums2[index+1],curr.a1+nums2[index+1],index+1));
            }
            k--;
        }
        
        return res;
    }
}