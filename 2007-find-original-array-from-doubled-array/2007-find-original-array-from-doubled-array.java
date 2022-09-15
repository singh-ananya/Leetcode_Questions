class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n=changed.length;
        if(n%2!=0)
            return new int[]{};
        
        Arrays.sort(changed);
        int ans[]=new int[n/2];
        int k=0;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<changed.length;i++){
           mp.put(changed[i],mp.getOrDefault(changed[i],0)+1); 
        }
        if(mp.containsKey(0) && mp.get(0)%2!=0){
            return new int[0];
        }
        for(int i=0;i<changed.length;i++){
            if(mp.containsKey(2*changed[i]) && mp.get(2*changed[i])>0 && mp.get(changed[i])>0){
                ans[k++]=changed[i];
                mp.put(changed[i],mp.get(changed[i])-1);
                mp.put(2*changed[i],mp.get(2*changed[i])-1);
            }
        }
        if(2*k==n)
            return ans;
        return new int[]{};
    }
}