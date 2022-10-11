class Solution {
    public String breakPalindrome(String str) {
        int len=str.length();
        if(len==1)
            return "";
        StringBuilder sb=new StringBuilder(str);
        for(int i=0;i<sb.length()/2;i++){
            if(sb.charAt(i)!='a'){
                sb.setCharAt(i,'a');
                return sb.toString();
            }
        }
        sb.setCharAt(len-1,'b');
        return sb.toString();
        
    }
}