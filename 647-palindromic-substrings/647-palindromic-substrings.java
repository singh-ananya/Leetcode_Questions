class Solution {
    public int countSubstrings(String str) {
         String temp = "";
        StringBuffer stf;
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1 ; j <=str.length(); j++) {
               
                temp = str.substring(i, j);
                
                    // Use StringBuffer class to reverse the string
                    stf = new StringBuffer(temp);
                    stf.reverse();
                    // Compare substring with reverse of substring
                    if (stf.toString().compareTo(temp) == 0)
                        count++;
                
            }
        }
        return count;
    }
}