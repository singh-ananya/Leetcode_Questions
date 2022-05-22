class Solution {
    public boolean ispal(String str){
        int st=0;
        int ed=str.length()-1;
        while(st<ed){
            if(str.charAt(st)!=str.charAt(ed))
                return false;
            st++;
            ed--;
        }
        return true;
    }
    public int countSubstrings(String str) {
        String temp = "";
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1 ; j <=str.length(); j++) {
                temp = str.substring(i, j);
                if(ispal(temp))
                    count++;
                
            }
        }
        return count;
    }
}