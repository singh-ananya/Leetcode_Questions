class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans[]=new int[2];
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int rem=target-numbers[i];
            if(mp.containsKey(rem)){
                ans[0]=mp.get(rem)+1;
                ans[1]=i+1;
            }
            mp.put(numbers[i],i);
        }
        
        return ans;
    }
}