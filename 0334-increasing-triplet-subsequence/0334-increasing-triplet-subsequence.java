class Solution {
    public boolean increasingTriplet(int[] nums) {
         int n = nums.length;
        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i]<=left){
                left=nums[i];
            }else if(nums[i]<=mid){
                mid = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}