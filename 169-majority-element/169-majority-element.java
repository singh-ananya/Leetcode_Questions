class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> en:mp.entrySet()){
            if(en.getValue()>nums.length/2){
                return en.getKey();
            }
        }
        return -1;
    }
}