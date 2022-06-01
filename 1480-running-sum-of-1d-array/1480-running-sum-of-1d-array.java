class Solution {
    public int[] runningSum(int[] nums) {
        int sumTillNow = 0;
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i] + sumTillNow;
            sumTillNow = nums[i];
        }
        return nums;
    }
}