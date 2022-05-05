class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem=target-nums[i];
            if(mp.containsKey(rem)){
                int ans[]={mp.get(rem),i};
                return ans;
            }
            mp.put(nums[i],i);
        }
        return null;
    }
}