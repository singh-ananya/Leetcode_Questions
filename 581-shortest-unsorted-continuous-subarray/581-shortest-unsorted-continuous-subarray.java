class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int arr[]=nums.clone();
        Arrays.sort(arr);
        int st=0;
        int ed=nums.length-1;
        while(st<ed){
            if(nums[st]==arr[st] && nums[ed]==arr[ed]){
                st++;
                ed--;
            }else if(nums[st]==arr[st]){
                st++;
            }else if(nums[ed]==arr[ed]){
                ed--;
            }else{
                return ed-st+1;
            }
        }
        return 0;
    }
}