class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Map<Integer,Integer> mp=new HashMap<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
            mp.put(nums[i],i);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                int sum=0-(nums[i]+nums[j]);
                if(mp.containsKey(sum) && mp.get(sum)>j){
                    ans.add(Arrays.asList(nums[i],nums[j],sum));
                }
            }
        }
        return ans;
    }
}