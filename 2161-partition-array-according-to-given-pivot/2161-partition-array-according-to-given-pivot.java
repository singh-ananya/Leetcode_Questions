class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       List<Integer> eq=new ArrayList<>(); 
        List<Integer> ls=new ArrayList<>(); 
        List<Integer> gr=new ArrayList<>(); 
        for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot){
                eq.add(nums[i]);
            }else if(nums[i]<pivot){
                ls.add(nums[i]);
            }else{
                gr.add(nums[i]);
            }
        }
        int ans[]=new int[nums.length];
        int k=0;
        for(int i=0;i<ls.size();i++){
            ans[k++]=ls.get(i);
        }
        for(int i=0;i<eq.size();i++){
            ans[k++]=eq.get(i);
        }
        for(int i=0;i<gr.size();i++){
            ans[k++]=gr.get(i);
        }
        return ans;
        
    }
}