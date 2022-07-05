class Solution {
    public int longestConsecutive(int[] nums) {
    Set <Integer> set = new HashSet <Integer>();
      for(int n : nums)
        set.add(n);
      
      int count = 0;
      for(int n : nums) {
        if(!set.contains(n - 1)) {
          int currNum = n;
          int curr_cnt = 1;
          
          while(set.contains(currNum + 1)) {
            currNum ++;
            curr_cnt ++;
          }
		  
          count = Math.max(count , curr_cnt);
      }
    }
      return count;
    }
}