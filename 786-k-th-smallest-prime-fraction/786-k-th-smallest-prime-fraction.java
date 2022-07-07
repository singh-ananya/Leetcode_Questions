class Solution {
    
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            double x=(double)a[0]/a[1];
            double y=(double)b[0]/b[1];
            if(x>y)
                return 1;
            else
                return -1;
            
        });
        int res[]=new int[2];
         if(arr.length == 0 || k == 0)
            return res;
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                pq.add(new int[]{arr[i],arr[j]});
            }
        }
        while(k-->0 && pq.size()>0){
            int curr[]=pq.remove();
            if(k==0){
                res[0]=curr[0];
                res[1]=curr[1];
            }
        }
        return res;
    }
}