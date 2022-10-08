class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closetsum=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<Math.abs(closetsum-target))
                    closetsum=sum;
                else if(sum>target)
                    right--;
                else
                    left++;
            }
        }
        return closetsum;
    }
}